package bt1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Viết một chương trình Java để kết nối với cơ sở dữ liệu MySQL. Các bước thực hiện:
//
//Tạo cơ sở dữ liệu tên là first_conection_db
//Tạo bảng users với cấu trúc:
//id – int
//name – varchar(255)
//email – varchar(255)
//Viết chương trình Java để:
//Kết nối đến first_conection_db
//In ra thông báo "Kết nối thành công!" nếu kết nối được, hoặc in lỗi nếu thất bại
public class Main {
    public static void main(String[] args) {
        Connection con;
        try {
            con = ConnectionDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "CREATE TABLE USERS (" +
                        "id INT PRIMARY KEY," +
                        "name VARCHAR(255)," +
                        "email VARCHAR(255))";
                stmt.executeUpdate(sql);
                System.out.println("Tạo bảng USERS thành công!");
            } catch (SQLException e) {
                System.err.println("Lỗi khi tạo bảng: " + e.getMessage());
            } finally {
                ConnectionDB.closeConnection(con);
            }
        }
    }
}
