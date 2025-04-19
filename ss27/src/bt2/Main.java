//Viết một chương trình Java sử dụng PreparedStatement để thêm một bản ghi mới vào bảng students gồm các thông tin như sau:
//
//id – int
//name – varchar(255)
//age – int
//major – varchar(255)
//Thực hiện cho người dùng nhập đầy đủ thông tin như trên và sử dụng PreparedStatement để thêm dữ liệu vào
package bt2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter student information:");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Major: ");
            String major = scanner.nextLine();

            connection = bt1.ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return;
            }

            String sql = "INSERT INTO students (id, name, age, major) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, major);

            // Execute update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student record added successfully!");
            } else {
                System.out.println("Failed to add student record.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                bt1.ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}
