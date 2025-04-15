package bt1;

public class ReportGenerator {
    public void generateEmployeeReport(Employee employee) {
        System.out.println("Employee Report");
        System.out.println("--------------");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("--------------");
    }

    public void generateSalaryReport(Employee employee, double salary) {
        System.out.println("Salary Report for " + employee.getName());
        System.out.println("--------------");
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Salary: $" + salary);
        System.out.println("--------------");
    }
}