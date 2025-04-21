package bt1;
/// /Viết chương trình Java, thực hiện các yêu cầu sau:
/// /
/// /Kết nối đến một cơ sở dữ liệu
/// /Kiểm tra trạng thái auto-commit ban đầu
/// /Tắt chế độ auto-commit
/// /Thực hiện một câu lệnh INSERT vào bảng (ví dụ: bảng users với các cột id, name, email)
/// /Gọi commit() để lưu thay đổi
/// /Xác minh rằng dữ liệu đã được thêm vào cơ sở dữ liệu

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to make connection!");
                return;
            }

            //  Kiểm tra trạng thái auto-commit ban đầu
            boolean autoCommit = connection.getAutoCommit();
            System.out.println("Initial auto-commit status: " + autoCommit);

            // Tắt chế độ auto-commit
            connection.setAutoCommit(false);
            System.out.println("Auto-commit status after turning off: " + connection.getAutoCommit());

            //  Tạo bảng nếu chưa tồn tại
            createTable(connection);

            //INSERT
            System.out.println("Inserting a new record...");
            String insertSQL = "INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com')";

            try (Statement stmt = connection.createStatement()) {
                int rowsAffected = stmt.executeUpdate(insertSQL);
                System.out.println(rowsAffected + " row(s) inserted.");

                // Gọi commit() để lưu thay đổi
                connection.commit();
                System.out.println("Transaction committed.");

                // Xác minh dữ liệu đã được thêm vào
                verifyData(connection);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Rollback transaction nếu có lỗi
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "email VARCHAR(100) NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    private static void verifyData(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("\nVerifying data in the database:");
            System.out.println("ID\tName\t\tEmail");
            System.out.println("----------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            }
        }
    }
}