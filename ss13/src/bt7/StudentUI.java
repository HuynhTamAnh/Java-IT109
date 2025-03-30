package bt7;
import java.util.List;
import java.util.Scanner;

public class StudentUI {
    private Scanner scanner;
    private StudentService service;

    public StudentUI() {
        scanner = new Scanner(System.in);
        service = new StudentService();
    }

    public void displayMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Show All Students");
        System.out.println("3. Find Student by Name");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processAddStudent() {
        System.out.println("\n----- ADD NEW STUDENT -----");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        service.addStudent(name, age, gpa);
        System.out.println("Student added successfully!");
    }

    public void displayAllStudents() {
        System.out.println("\n----- STUDENT LIST -----");
        if (!service.hasStudents()) {
            System.out.println("No students in the list.");
            return;
        }

        System.out.println("Name - Age - GPA");
        for (Student student : service.getAllStudents()) {
            System.out.println(student);
        }
    }

    public void searchStudents() {
        System.out.println("\n----- SEARCH STUDENTS -----");
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine();

        List<Student> results = service.findStudentsByName(name);

        if (results.isEmpty()) {
            System.out.println("No students found with that name.");
        } else {
            System.out.println("\nSearch results:");
            for (Student student : results) {
                System.out.println(student);
            }
        }
    }

    public void close() {
        scanner.close();
    }
}