package bt3;
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Tạo cơ sở dữ liệu tên là my_db
//Tạo bảng employees với thông tin như sau:
//id – int
//name – varchar(255)
//address – varchar(255)
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con;
        try {
            con = bt3.ConnectionDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Create table IF NOT EXISTS employees(" +
                        "id INT primary key AUTO_INCREMENT," +
                        "name varchar(255)," +
                        "address varchar(255) )");

                stmt.executeUpdate("INSERT INTO employees(name,address)" +
                        "values ('hung hx','hn')," +
                        "('kha','đn')," +
                        "('hao','trời')");
                ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
                while (rs.next()){
                    System.out.printf(
                            "id: %-5d | name: %-20s | address: %-20s \n",
                            rs.getInt("id"),rs.getString("name"),rs.getString("address")
                    );
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                bt3.ConnectionDB.closeConnection(con);
            }

        }
    }
}