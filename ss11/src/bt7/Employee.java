package bt7;

public abstract class Employee implements IEmployee {
    // Các thuộc tính chung về nhân viên
    protected String name;
    protected double paymentPerHour;

    public Employee(String name, double paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPaymentPerHour(double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public double getPaymentPerHour() {
        return this.paymentPerHour;
    }

    public abstract double calculateSalary();
}