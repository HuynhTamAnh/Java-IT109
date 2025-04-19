package bt6;
//Sử dụng dữ liệu các bảng employee và department từ bài 5
//Viết một chương trình Java sử dụng CallableStatement để gọi stored procedure calculateTotalSalaryByDept
//Với procedure calculateTotalSalaryByDept nhận vào tham số department_id để thực hiện tính toán theo phòng ban
import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return;
            }

            initializeDatabase(connection);

            createStoredProcedure(connection);

            System.out.print("Enter department ID (leave blank for all departments): ");
            String deptIdInput = scanner.nextLine().trim();
            Integer departmentId = deptIdInput.isEmpty() ? null : Integer.parseInt(deptIdInput);

            String call;
            if (departmentId != null) {
                call = "{call calculateTotalSalaryByDept(?)}";
                callableStatement = connection.prepareCall(call);
                callableStatement.setInt(1, departmentId);
            } else {
                call = "{call calculateTotalSalaryByDept(NULL)}";
                callableStatement = connection.prepareCall(call);
            }

            boolean hasResults = callableStatement.execute();

            System.out.println("\nSalary Report:");
            System.out.println("Department\tTotal Salary\tEmployee Count");
            System.out.println("----------------------------------------------");

            if (hasResults) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    System.out.printf("%-15s\t%,.2f\t\t%d\n",
                            resultSet.getString("department_name"),
                            resultSet.getDouble("total_salary"),
                            resultSet.getInt("employee_count"));
                }
                resultSet.close();
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
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

    private static void createStoredProcedure(Connection connection) throws SQLException {
        boolean procedureExists = false;
        ResultSet rs = connection.getMetaData().getProcedures(null, null, "calculateTotalSalaryByDept");
        if (rs.next()) {
            procedureExists = true;
        }
        rs.close();

        if (!procedureExists) {
            try (Statement stmt = connection.createStatement()) {
                String procedureSQL =
                        "CREATE PROCEDURE calculateTotalSalaryByDept(IN dept_id INT) " +
                                "BEGIN " +
                                "   IF dept_id IS NULL THEN " +
                                "       SELECT d.name AS department_name, " +
                                "              SUM(e.salary) AS total_salary, " +
                                "              COUNT(e.id) AS employee_count " +
                                "       FROM department d " +
                                "       LEFT JOIN employee e ON d.id = e.department_id " +
                                "       GROUP BY d.id, d.name " +
                                "       UNION " +
                                "       SELECT 'No Department' AS department_name, " +
                                "              SUM(salary) AS total_salary, " +
                                "              COUNT(id) AS employee_count " +
                                "       FROM employee " +
                                "       WHERE department_id IS NULL; " +
                                "   ELSE " +
                                "       SELECT d.name AS department_name, " +
                                "              SUM(e.salary) AS total_salary, " +
                                "              COUNT(e.id) AS employee_count " +
                                "       FROM department d " +
                                "       LEFT JOIN employee e ON d.id = e.department_id " +
                                "       WHERE d.id = dept_id " +
                                "       GROUP BY d.id, d.name; " +
                                "   END IF; " +
                                "END";
                stmt.executeUpdate(procedureSQL);
                System.out.println("Stored procedure 'calculateTotalSalaryByDept' created successfully.");
            }
        }
    }
}