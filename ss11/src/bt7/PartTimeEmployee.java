package bt7;

public class PartTimeEmployee extends Employee {
    private double workingHours;

    // Constructor
    public PartTimeEmployee(String name, double paymentPerHour, double workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return workingHours * paymentPerHour;
    }
}