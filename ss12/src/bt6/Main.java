package bt6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Nguyễn Văn A", 30, 5000000, 1000000),
                new PartTimeEmployee("Trần Thị B", 25, 50000, 80),
                new Intern("Lê Văn C", 22, 3000000)
        };

        // Hiển thị
        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println("------------------------");
        }
    }
}
