package bt7;

public class Main {
    public static void main(String[] args) {
        // Tạo nhân viên bán thời gian
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Nguyen Van A", 50000, 4);

        // Tạo nhân viên toàn thời gian
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Tran Thi B", 100000);

        // In thông tin và lương
        System.out.println("Part-time Employee:");
        System.out.println("Name: " + partTimeEmployee.getName());
        System.out.println("Salary: " + partTimeEmployee.calculateSalary());

        System.out.println("\nFull-time Employee:");
        System.out.println("Name: " + fullTimeEmployee.getName());
        System.out.println("Salary: " + fullTimeEmployee.calculateSalary());
    }
}