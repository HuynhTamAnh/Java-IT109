package bt2;
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Kết nối đến một cơ sở dữ liệu
//Kiểm tra trạng thái auto-commit ban đầu
//Tắt chế độ auto-commit
//Thực hiện một câu lệnh INSERT vào bảng (ví dụ: bảng users với các cột id, name, email)
//Gọi commit() để lưu thay đổi
//Xác minh rằng dữ liệu đã được thêm vào cơ sở dữ liệu
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.err.println("Failed to establish database connection!");
                return;
            }

            System.out.println("Initial auto-commit status: " + connection.getAutoCommit());

            connection.setAutoCommit(false);
            System.out.println("Auto-commit status after change: " + connection.getAutoCommit());

            createUsersTable(connection);

            System.out.println("\nInserting new user...");
            int newUserId = insertUser(connection, "Jane Smith", "jane.smith@example.com");
            System.out.println("New user ID: " + newUserId);

            connection.commit();
            System.out.println("Transaction committed successfully.");

            verifyInsertedData(connection);

        } catch (SQLException e) {
            System.err.println("Database error occurred:");
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error.");
                } catch (SQLException ex) {
                    System.err.println("Failed to rollback transaction:");
                    ex.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    System.err.println("Failed to restore auto-commit status:");
                    e.printStackTrace();
                }
                ConnectionDB.closeConnection(connection);
            }
        }
    }

    private static void createUsersTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) NOT NULL UNIQUE)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Users table created/verified");
        }
    }

    private static int insertUser(Connection connection, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }

    private static void verifyInsertedData(Connection connection) throws SQLException {
        String sql = "SELECT id, name, email FROM users ORDER BY id DESC LIMIT 1";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nVerifying most recently added record:");
            System.out.println("ID\tName\t\tEmail");
            System.out.println("----------------------------------");

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            } else {
                System.out.println("No records found in users table");
            }
        }
    }
}