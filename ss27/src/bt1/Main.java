//Tạo database tên là my_db_1
//
//Tạo table employees gồm các thông tin sau:
//
//id – int
//name – varchar(255)
//salary – double
//Viết một chương trình Java sử dụng PreparedStatement để lấy thông tin từ bảng employees dựa trên id được nhập vào từ bàn phím và hiển thị ra màn hình các cột id, name, salary
package bt1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();

            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return;
            }

            String sql = "SELECT id, name, salary FROM employees WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println("Employee Details:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            } else {
                System.out.println("No employee found with ID: " + employeeId);
            }

        } catch (SQLException e) {
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
}