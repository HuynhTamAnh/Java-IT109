package bt2;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    //constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    //method
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //method tang luong nhan vien theo percentage
    public void incrementSalary(double percentage) {
        this.salary += this.salary*percentage/100;
    }

    public static void main(String[] args) {
        Employee employee = new Employee(1, "John", "Doe", 10.0);
        System.out.println("thong tin nhan vien: ");
        employee.displayInfo();
        System.out.println("luong hien tai: "+employee.getSalary());

        //tăng lương 10%
        employee.incrementSalary(10);
        System.out.println("luong sau khi tang: "+employee.getSalary());
    }
}
