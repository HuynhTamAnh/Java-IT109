package bt6;

class PartTimeEmployee extends Employee {
    private int workHours;

    public PartTimeEmployee(String name, int age, double basicSalary, int workHours) {
        super(name, age, basicSalary);
        this.workHours = workHours;
    }

    @Override
    public double calculateSalary() {
        return basicSalary * workHours;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Loại: Nhân viên bán thời gian");
        System.out.println("Số giờ làm việc: " + workHours);
        System.out.println("Tổng lương: " + calculateSalary());
    }
}
