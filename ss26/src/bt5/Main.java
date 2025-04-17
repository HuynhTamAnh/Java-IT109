package bt5;
//Thực hiện tạo database tên my_db_5
//
//Tạo bảng employees gồm các thông tin như sau:
//
//id – int
//name – varchar(255)
//age – int
//salary – double
//Thêm dữ liệu mẫu 7 đến 10 bản ghi
//
//
//
//Viết chương trình Java để:
//
//Lấy danh sách tất cả nhân viên sắp xếp theo mức lương giảm dần.
//Chỉ hiển thị tối đa 5 nhân viên đầu tiên trong kết quả
//Sử dụng câu lệnh SQL SELECT ... ORDER BY ... LIMIT để thực hiện

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = ConnectionDB.openConnection();

            createTable(connection);

            if (isTableEmpty(connection)) {
                insertSampleData(connection);
            }

            // Hiển thị 5 nhân viên có lương cao nhất
            showTop5Employees(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "age INT, " +
                "salary DOUBLE)";
        stmt.execute(sql);
        stmt.close();
    }

    private static boolean isTableEmpty(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM employees");
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();
        return count == 0;
    }

    private static void insertSampleData(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("INSERT INTO employees (name, age, salary) VALUES " +
                "('Nguyễn Văn A', 30, 15000000), " +
                "('Trần Thị B', 28, 18000000), " +
                "('Lê Văn C', 35, 22000000), " +
                "('Phạm Thị D', 32, 16000000), " +
                "('Hoàng Văn E', 40, 25000000), " +
                "('Vũ Thị F', 27, 14000000), " +
                "('Đặng Văn G', 45, 28000000), " +
                "('Bùi Thị H', 33, 19000000)");

        stmt.close();
    }

    private static void showTop5Employees(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT id, name, age, salary FROM employees ORDER BY salary DESC LIMIT 5");

        System.out.println("TOP 5 NHÂN VIÊN CÓ LƯƠNG CAO NHẤT");
        System.out.println("--------------------------------------");
        System.out.printf("%-5s %-20s %-5s %-15s%n", "ID", "Họ và tên", "Tuổi", "Lương");
        System.out.println("--------------------------------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            double salary = rs.getDouble("salary");

            System.out.printf("%-5d %-20s %-5d %-,15.0f%n", id, name, age, salary);
        }

        System.out.println("--------------------------------------");
        rs.close();
        stmt.close();
    }
}