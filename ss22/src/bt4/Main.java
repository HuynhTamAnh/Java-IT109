package bt4;
//Viết chương trình Java thực hiện các bước sau:
//
//Định nghĩa lớp Student có 3 thuộc tính:
//name – kiểu String
//age – kiểu int
//score – kiểu double
// Lưu ý: lớp Student cần implement Serializable.
//Tạo một đối tượng Student với thông tin bất kỳ.
//Ghi đối tượng đó vào file nhị phân (ví dụ: student.dat) bằng ObjectOutputStream.
//Thông báo ra màn hình: "Đã ghi đối tượng vào file student.dat".
//Đọc lại đối tượng vừa ghi từ file bằng ObjectInputStream.
//Thông báo ra màn hình: "Đã đọc đối tượng từ file student.dat".
//Hiển thị thông tin của đối tượng vừa đọc ra màn hình.
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Nguyen Van Kha", 20, 8.5);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        // Đọc từ file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.txt");
            System.out.println("Thông tin đối tượng:");
            System.out.println(readStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
