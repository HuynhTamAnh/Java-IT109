package bt6;
//Thực hiện tạo database tên my_db_6
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
//Viết chương trình Java sử dụng Statement để thực hiện các truy vấn sau trên bảng employees:
//
//Tính tổng số lượng nhân viên
//Tính mức lương trung bình của toàn bộ nhân viên
//Tìm mức lương cao nhất và thấp nhất
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = ConnectionDB.openConnection();

            createEmployeesTable(connection);

            if (isTableEmpty(connection)) {
                insertSampleData(connection);
            }

            performEmployeeStatistics(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    private static void createEmployeesTable(Connection conn) throws SQLException {
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

        // Thêm dữ liệu mẫu với tên tiếng Việt
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

    private static void performEmployeeStatistics(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        // 1. Tính tổng số lượng nhân viên
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total_employees FROM employees");
        rs.next();
        int totalEmployees = rs.getInt("total_employees");
        System.out.println("Tổng số nhân viên: " + totalEmployees);

        // 2. Tính mức lương trung bình
        rs = stmt.executeQuery("SELECT AVG(salary) AS avg_salary FROM employees");
        rs.next();
        double avgSalary = rs.getDouble("avg_salary");
        System.out.printf("Lương trung bình: %,.0f VND\n", avgSalary);

        // 3. Tìm mức lương cao nhất và thấp nhất
        rs = stmt.executeQuery("SELECT MAX(salary) AS max_salary, MIN(salary) AS min_salary FROM employees");
        rs.next();
        double maxSalary = rs.getDouble("max_salary");
        double minSalary = rs.getDouble("min_salary");
        System.out.printf("Lương cao nhất: %,.0f VND\n", maxSalary);
        System.out.printf("Lương thấp nhất: %,.0f VND\n", minSalary);

        // Đóng kết nối
        rs.close();
        stmt.close();
    }
}