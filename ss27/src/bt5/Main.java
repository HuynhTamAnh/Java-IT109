//Tạo database tên là my_db
//
//Tạo 2 bảng employee và department gồm thông tin như sau:
//
//department:
//id – int
//name – varchar(50)
//employee:
//id – int
//name – varchar(50)
//salary – double
//department_id – int
//
//
//Viết một chương trình Java sử dụng PreparedStatement để tìm kiếm các nhân viên trong bảng employees theo các tiêu chí do người dùng nhập vào.
package bt5;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return;
            }

            initializeDatabase(connection);

            System.out.println("Enter search criteria (leave blank to skip):");

            System.out.print("Employee name contains: ");
            String name = scanner.nextLine().trim();

            System.out.print("Department ID: ");
            String deptIdInput = scanner.nextLine().trim();
            Integer departmentId = deptIdInput.isEmpty() ? null : Integer.parseInt(deptIdInput);

            System.out.print("Minimum salary: ");
            String salaryInput = scanner.nextLine().trim();
            Double minSalary = salaryInput.isEmpty() ? null : Double.parseDouble(salaryInput);

            StringBuilder sqlBuilder = new StringBuilder(
                    "SELECT e.id, e.name, e.salary, d.name AS department_name " +
                            "FROM employee e " +
                            "LEFT JOIN department d ON e.department_id = d.id " +
                            "WHERE 1=1");

            if (!name.isEmpty()) {
                sqlBuilder.append(" AND e.name LIKE ?");
            }
            if (departmentId != null) {
                sqlBuilder.append(" AND e.department_id = ?");
            }
            if (minSalary != null) {
                sqlBuilder.append(" AND e.salary >= ?");
            }

            preparedStatement = connection.prepareStatement(sqlBuilder.toString());

            int paramIndex = 1;
            if (!name.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + name + "%");
            }
            if (departmentId != null) {
                preparedStatement.setInt(paramIndex++, departmentId);
            }
            if (minSalary != null) {
                preparedStatement.setDouble(paramIndex++, minSalary);
            }

            // Execute query
            resultSet = preparedStatement.executeQuery();

            System.out.println("\nSearch Results:");
            System.out.println("ID\tName\t\tSalary\t\tDepartment");
            System.out.println("------------------------------------------------");

            boolean hasResults = false;
            while (resultSet.next()) {
                hasResults = true;
                System.out.printf("%d\t%-10s\t%.2f\t\t%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("department_name"));
            }

            if (!hasResults) {
                System.out.println("No employees found matching the criteria.");
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    private static void initializeDatabase(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS department (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50))");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "salary DOUBLE, " +
                    "department_id INT, " +
                    "FOREIGN KEY (department_id) REFERENCES department(id))");

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM department");
            rs.next();
            if (rs.getInt(1) == 0) {
                stmt.executeUpdate("INSERT INTO department VALUES (1, 'IT')");
                stmt.executeUpdate("INSERT INTO department VALUES (2, 'HR')");
                stmt.executeUpdate("INSERT INTO department VALUES (3, 'Finance')");

                stmt.executeUpdate("INSERT INTO employee VALUES (101, 'John Smith', 5000.0, 1)");
                stmt.executeUpdate("INSERT INTO employee VALUES (102, 'Jane Doe', 6000.0, 2)");
                stmt.executeUpdate("INSERT INTO employee VALUES (103, 'Mike Johnson', 5500.0, 1)");
                stmt.executeUpdate("INSERT INTO employee VALUES (104, 'Sarah Williams', 4500.0, 3)");
                stmt.executeUpdate("INSERT INTO employee VALUES (105, 'David Brown', 7000.0, null)");
            }
            rs.close();
        }
    }
}