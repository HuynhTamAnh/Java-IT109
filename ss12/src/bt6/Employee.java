package bt6;

// Lớp cha Employee
abstract class Employee {
    protected String name;
    protected int age;
    protected double basicSalary;

    // Constructor
    public Employee(String name, int age, double basicSalary) {
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    //cth tính lương
    public abstract double calculateSalary();

    public void showInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Lương cơ bản: " + basicSalary);
    }
}