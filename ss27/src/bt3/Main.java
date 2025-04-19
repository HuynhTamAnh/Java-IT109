//Tạo database tên là my_db_3
//
//Tạo table employees gồm các thông tin như sau:
//
//Id – int
//Name – varchar(255)
//Salary – double
//Viết một chương trình Java sử dụng PreparedStatement để cập nhật mức lương của nhân viên dựa trên id
//
//Dữ liệu nhân viên sẽ được fix cứng trong database
//Người dùng nhập vào id muốn cập nhật
//Cho người dùng nhập lương cần cập nhật
//Thực hiện câu lệnh UPDATE trong SQL để update lượng nhân viên theo id
package bt3;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return;
            }

            initializeDatabase(connection);

            displayEmployees(connection);

            System.out.print("\nEnter employee ID to update: ");
            int id = scanner.nextInt();

            System.out.print("Enter new salary: ");
            double newSalary = scanner.nextDouble();

            String sql = "UPDATE employees SET salary = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters
            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, id);

            // Execute update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nSalary updated successfully!");
                System.out.println("Updated employee details:");
                displayEmployeeById(connection, id);
            } else {
                System.out.println("\nNo employee found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "salary DOUBLE)";
            stmt.executeUpdate(createTableSQL);

            // Insert sample data if table is empty
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM employees");
            rs.next();
            if (rs.getInt(1) == 0) {
                stmt.executeUpdate("INSERT INTO employees VALUES (1, 'John Doe', 5000.0)");
                stmt.executeUpdate("INSERT INTO employees VALUES (2, 'Jane Smith', 6000.0)");
                stmt.executeUpdate("INSERT INTO employees VALUES (3, 'Mike Johnson', 5500.0)");
            }
        }
    }

    private static void displayEmployees(Connection connection) throws SQLException {
        System.out.println("\nCurrent Employees:");
        System.out.println("ID\tName\t\tSalary");
        System.out.println("--------------------------------");

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.printf("%d\t%-10s\t%.2f\n", id, name, salary);
            }
        }
    }

    private static void displayEmployeeById(Connection connection, int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID\tName\t\tSalary");
                    System.out.println("--------------------------------");
                    System.out.printf("%d\t%-10s\t%.2f\n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary"));
                }
            }
        }
    }
}