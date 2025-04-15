package bt1;

public class SalaryCalculator {
    public double calculateSalary(Employee employee, double baseSalary, double bonus) {
        return baseSalary + bonus;
    }

    public double calculateMonthlySalary(Employee employee, double hourlyRate, double hoursWorked) {
        return hourlyRate * hoursWorked;
    }
}