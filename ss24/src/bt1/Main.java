package bt1;
//Viết một chương trình quản lý nhân viên. Một lớp Employee chỉ chịu trách nhiệm quản lý thông tin nhân viên, các chức năng khác như tính lương, in báo cáo nên được chuyển sang các lớp riêng.
//
//Yêu cầu:
//
//Tạo lớp Employee lưu trữ thông tin cơ bản như:
//id – int
//name – String
//Tạo lớp SalaryCalculator để tính lương
//Tạo lớp ReportGenerator để tạo báo cáo
//Tạo lớp Main để kiểm thử chức năng đã làm
public class Main {
    public static void main(String[] args) {
        // Create an employee
        Employee employee = new Employee(1, "John Doe");

        // tính lương
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        double salary = salaryCalculator.calculateSalary(employee, 50000, 5000);

        // tạo báo cáo
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateEmployeeReport(employee);
        reportGenerator.generateSalaryReport(employee, salary);

        double monthlySalary = salaryCalculator.calculateMonthlySalary(employee, 25.0, 160);
        reportGenerator.generateSalaryReport(employee, monthlySalary);
    }
}