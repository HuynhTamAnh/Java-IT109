package bt4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Viết chương trình Java để:
//
//Tạo một lớp Person:
//Thuộc tính: name(String), birthDate (LocalDate)
//Phương thức:
//getAge(): Trả về tuổi của Person ở thời điểm hiện tại
//printInfo(): In ra thông tin Person theo định dạng sau
// "Tên: …, Ngày sinh: …, Tuổi: …"
//Khởi tạo danh sách Person theo mẫu:
//List<Person> people = List.of(
//
//    new Person("Quý", LocalDate.of(2000, 3, 25)),
//
//    new Person("Lan", LocalDate.of(1998, 7, 10)),
//
//    new Person("Minh", LocalDate.of(2005, 12, 1))
//
//);
//
//Gọi phương thức printInfo để in ra thông tin của từng Person.
//  Yêu cầu:
//
//Sử dụng LocalDate, Period.between() để tính số năm tuổi.
//Không dùng Calendar hoặc Date kiểu cũ.
//Có thể tạo nhiều người dùng để hiển thị nhiều độ tuổi khác nhau
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Q", LocalDate.of(2000, 3, 25)),
                new Person("L", LocalDate.of(1998, 7, 10)),
                new Person("M", LocalDate.of(2005, 12, 1)),
                new Person("H", LocalDate.of(1985, 5, 15)),
                new Person("Th", LocalDate.of(2010, 1, 20))
        );

        // In ra thông tin của từng Person
        for (Person person : people) {
            person.printInfo();
        }
    }
}

