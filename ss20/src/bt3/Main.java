package bt3;

import java.util.List;
import java.util.Optional;

//Một người dùng trong hệ thống có thể có hoặc không có số điện thoại. Viết chương trình:
//
//Tạo một lớp User
//Thuộc tính: name(String) và phoneNumber(Optional<String>).
//Phương thức: printInfo() - In ra thông tin người dùng như sau:
//Nếu có số điện thoại: "Tên: ..., SĐT: ..."
//Nếu không có: "Tên: ..., SĐT: Không có"
//Khởi tạo lần lượt các User theo câu lệnh sau:
//List<User> users = List.of(
//
//            new User("Quý", "0987654321"),
//
//            new User("Lan", null),
//
//            new User("Minh", "0933222111"),
//
//            new User("Huyền", null)
//
//        );
//
//In ra thông tin của từng người dùng(User).
public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Quý", "0987654321"),
                new User("Lan", null),
                new User("Minh", "0933222111"),
                new User("Huyền", null)
        );

        users.forEach(User::printInfo);
    }
}
