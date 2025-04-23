package main.ra.edu.presentation;

import main.ra.edu.business.service.CourseService;
import main.ra.edu.business.service.StudentService;
import main.ra.edu.entity.Course;
import main.ra.edu.entity.Student;
import main.ra.edu.utils.FormatUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CourseService courseService = new CourseService();
    private static StudentService studentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ ĐÀO TẠO ===");
            System.out.println("1. Quản lý khóa học");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (mainChoice) {
                    case 1:
                        manageCourses();
                        break;
                    case 2:
                        manageStudents();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi database: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi dữ liệu: " + e.getMessage());
            }
        }

        System.out.println("Kết thúc chương trình.");
        scanner.close();
    }

    private static void manageCourses() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== QUẢN LÝ KHÓA HỌC ===");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm khóa học mới");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học");
            System.out.println("5. Quay lại");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void manageStudents() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Quay lại");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void listCourses() throws SQLException {
        List<Course> courses = courseService.getAll();
        System.out.println("\nDANH SÁCH KHÓA HỌC:");
        System.out.println("+-----+------------------------------+--------------------------------+");
        System.out.println("| ID  | Tên khóa học                 | Mô tả                          |");
        System.out.println("+-----+------------------------------+--------------------------------+");

        for (Course course : courses) {
            System.out.printf("| %-3d | %-28s | %-30s |\n",
                    course.getId(),
                    course.getName(),
                    course.getDescription());
        }
        System.out.println("+-----+------------------------------+--------------------------------+");
    }

    private static void addCourse() throws SQLException {
        System.out.println("\nTHÊM KHÓA HỌC MỚI");
        System.out.print("Nhập tên khóa học: ");
        String name = scanner.nextLine();

        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        Course newCourse = new Course(name, description);
        if (courseService.add(newCourse)) {
            System.out.println("Thêm khóa học thành công!");
        } else {
            System.out.println("Thêm khóa học thất bại!");
        }
    }

    private static void updateCourse() throws SQLException {
        System.out.print("\nNhập ID khóa học cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course course = courseService.getById(id);
        if (course == null) {
            System.out.println("Không tìm thấy khóa học!");
            return;
        }

        System.out.print("Nhập tên mới (" + course.getName() + "): ");
        String name = scanner.nextLine();

        System.out.print("Nhập mô tả mới (" + course.getDescription() + "): ");
        String description = scanner.nextLine();

        course.setName(name.isEmpty() ? course.getName() : name);
        course.setDescription(description.isEmpty() ? course.getDescription() : description);

        if (courseService.update(course)) {
            System.out.println("Cập nhật khóa học thành công!");
        } else {
            System.out.println("Cập nhật khóa học thất bại!");
        }
    }

    private static void deleteCourse() throws SQLException {
        System.out.print("\nNhập ID khóa học cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (courseService.delete(id)) {
            System.out.println("Xóa khóa học thành công!");
        } else {
            System.out.println("Xóa khóa học thất bại! Khóa học có thể đã có sinh viên đăng ký.");
        }
    }

    // Các phương thức quản lý sinh viên
    private static void listStudents() throws SQLException {
        List<Student> students = studentService.getAll();
        System.out.println("\nDANH SÁCH SINH VIÊN:");
        System.out.println("+-----+----------------------+----------------------+----------------+--------+------------+---------+----------------+--------+");
        System.out.println("| ID  | Họ và tên           | Email                | Số điện thoại  | Giới tính | Ngày sinh  | Khóa học | Avatar         | Trạng thái |");
        System.out.println("+-----+----------------------+----------------------+----------------+--------+------------+---------+----------------+--------+");

        for (Student student : students) {
            System.out.printf("| %-3s | %-20s | %-20s | %-14s | %-6s | %-10s | %-7d | %-14s | %-6s |\n",
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getPhone(),
                    student.isSex() ? "Nam" : "Nữ",
                    FormatUtils.formatDate(student.getBod()),
                    student.getCourseId(),
                    student.getAvatar() != null ? "Có ảnh" : "Không ảnh",
                    student.isStatus() ? "Hoạt động" : "Khóa");
        }
        System.out.println("+-----+----------------------+----------------------+----------------+--------+------------+---------+----------------+--------+");
    }

    private static void addStudent() throws SQLException {
        System.out.println("\nTHÊM SINH VIÊN MỚI");

        System.out.print("Nhập mã sinh viên (5 ký tự): ");
        String id = scanner.nextLine();

        System.out.print("Nhập họ và tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        System.out.print("Nhập giới tính (Nam/Nữ): ");
        boolean sex = scanner.nextLine().equalsIgnoreCase("Nam");

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String bodStr = scanner.nextLine();
        Date bod = FormatUtils.parseDate(bodStr);

        System.out.print("Nhập ID khóa học: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Nhập đường dẫn avatar (Enter để bỏ qua): ");
        String avatar = scanner.nextLine();

        System.out.print("Trạng thái (1-Hoạt động/0-Khóa): ");
        boolean status = scanner.nextInt() == 1;
        scanner.nextLine(); // Consume newline

        Student newStudent = new Student(id, name, email, phone, sex, bod, courseId, avatar, status);
        if (studentService.add(newStudent)) {
            System.out.println("Thêm sinh viên thành công!");
        } else {
            System.out.println("Thêm sinh viên thất bại!");
        }
    }

    private static void updateStudent() throws SQLException {
        System.out.print("\nNhập ID sinh viên cần cập nhật: ");
        String id = scanner.nextLine();

        Student student = studentService.getById(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }

        System.out.print("Nhập họ tên mới (" + student.getName() + "): ");
        String name = scanner.nextLine();

        System.out.print("Nhập email mới (" + student.getEmail() + "): ");
        String email = scanner.nextLine();

        System.out.print("Nhập số điện thoại mới (" + student.getPhone() + "): ");
        String phone = scanner.nextLine();

        System.out.print("Nhập giới tính mới (" + (student.isSex() ? "Nam" : "Nữ") + "): ");
        boolean sex = scanner.nextLine().equalsIgnoreCase("Nam");

        System.out.print("Nhập ngày sinh mới (" + FormatUtils.formatDate(student.getBod()) + "): ");
        String bodStr = scanner.nextLine();
        Date bod = bodStr.isEmpty() ? student.getBod() : FormatUtils.parseDate(bodStr);

        System.out.print("Nhập ID khóa học mới (" + student.getCourseId() + "): ");
        String courseIdStr = scanner.nextLine();
        int courseId = courseIdStr.isEmpty() ? student.getCourseId() : Integer.parseInt(courseIdStr);

        System.out.print("Nhập đường dẫn avatar mới (" + student.getAvatar() + "): ");
        String avatar = scanner.nextLine();

        System.out.print("Trạng thái mới (" + (student.isStatus() ? "Hoạt động" : "Khóa") + "): ");
        String statusStr = scanner.nextLine();
        boolean status = statusStr.isEmpty() ? student.isStatus() : statusStr.equals("1");

        student.setName(name.isEmpty() ? student.getName() : name);
        student.setEmail(email.isEmpty() ? student.getEmail() : email);
        student.setPhone(phone.isEmpty() ? student.getPhone() : phone);
        student.setSex(sex);
        student.setBod(bod);
        student.setCourseId(courseId);
        student.setAvatar(avatar.isEmpty() ? student.getAvatar() : avatar);
        student.setStatus(status);

        if (studentService.update(student)) {
            System.out.println("Cập nhật sinh viên thành công!");
        } else {
            System.out.println("Cập nhật sinh viên thất bại!");
        }
    }

    private static void deleteStudent() throws SQLException {
        System.out.print("\nNhập ID sinh viên cần xóa: ");
        String id = scanner.nextLine();

        if (studentService.delete(id)) {
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Xóa sinh viên thất bại!");
        }
    }

    private static void searchStudentByName() throws SQLException {
        System.out.print("\nNhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();

        List<Student> students = studentService.searchByName(name);
        if (students.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào!");
            return;
        }

        System.out.println("\nKẾT QUẢ TÌM KIẾM:");
        System.out.println("+-----+----------------------+----------------------+----------------+--------+------------+---------+");
        System.out.println("| ID  | Họ và tên           | Email                | Số điện thoại  | Giới tính | Ngày sinh  | Khóa học |");
        System.out.println("+-----+----------------------+----------------------+----------------+--------+------------+---------+");

        for (Student student : students) {
            System.out.printf("| %-3s | %-20s | %-20s | %-14s | %-6s | %-10s | %-7d |\n",
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getPhone(),
                    student.isSex() ? "Nam" : "Nữ",
                    FormatUtils.formatDate(student.getBod()),
                    student.getCourseId());
        }
        System.out.println("+-----+----------------------+----------------------+----------------+--------+------------+---------+");
    }
}