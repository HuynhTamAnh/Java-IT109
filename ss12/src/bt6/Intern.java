package bt6;

class Intern extends Employee {
    public Intern(String name, int age, double basicSalary) {
        super(name, age, basicSalary);
    }

    @Override
    public double calculateSalary() {
        return basicSalary;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Loại: Nhân viên thực tập");
        System.out.println("Tổng lương: " + calculateSalary());
    }
}

