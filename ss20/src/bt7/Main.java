package bt7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Viết chương trình sử dụng Stream API để lọc ra danh sách nhân viên:
//
//Khởi tạo đối tượng Employee:
//Thuộc tính: name - String, age - int, department - String, salary - double
//Constructor: Đầy đủ tham số và không có tham số
//Phương thức: getter, setter, toString()
//Lọc ra danh sách nhân viên thỏa mãn các điều kiện:
//Lương lớn hơn 2000
//Tuổi từ 25 trở lên
//Phòng ban là "IT"
//Sau khi lọc, sắp xếp danh sách:
//Theo mức lương giảm dần
//Nếu bằng lương thì theo tên (tăng dần)
//Khởi tạo danh sách sinh viên:
//List<Employee> employees = List.of(
//
//            new Employee("Quý", 26, "IT", 2500),
//
//            new Employee("Lan", 24, "IT", 2100),
//
//            new Employee("Minh", 30, "HR", 3000),
//
//            new Employee("Huyền", 28, "IT", 2000),
//
//            new Employee("Long", 32, "IT", 3100),
//
//            new Employee("Trang", 25, "Marketing", 2200),
//
//            new Employee("Việt", 27, "IT", 2500)
//
//        );
//
//In ra danh sách kết quả, gồm: Tên nhân viên, Tuổi, Phòng ban, Lương
public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Quý", 26, "IT", 2500),
                new Employee("Lan", 24, "IT", 2100),
                new Employee("Minh", 30, "HR", 3000),
                new Employee("Huyền", 28, "IT", 2000),
                new Employee("Long", 32, "IT", 3100),
                new Employee("Trang", 25, "Marketing", 2200),
                new Employee("Việt", 27, "IT", 2500)
        );

        // lọc và sắp xếp nhân viên
        List<Employee> filteredEmployees = employees.stream()
                // Lọc theo điều kiện: Lương > 2000, Tuổi >= 25, Phòng ban = "IT"
                .filter(emp -> emp.getSalary() > 2000)
                .filter(emp -> emp.getAge() >= 25)
                .filter(emp -> emp.getDepartment().equals("IT"))
                // Sắp xếp theo lương giảm dần, nếu bằng lương thì theo tên tăng dần
                .sorted(Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))//thêm cái để sắp xếp, nếu cùng mức lương thì in theo tên(tăng dần)
                .toList();

        System.out.println("Danh sách nhân viên sau khi lọc và sắp xếp:");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s %-5s %-12s %-8s%n", "Tên", "Tuổi", "Phòng ban", "Lương");
        System.out.println("--------------------------------------------");

        for (Employee emp : filteredEmployees) {
            System.out.printf("%-10s %-5d %-12s %-8.2f%n",
                    emp.getName(),
                    emp.getAge(),
                    emp.getDepartment(),
                    emp.getSalary());
        }
    }
}