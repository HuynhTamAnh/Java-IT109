package bt4;
//Bài tập yêu cầu sinh viên xây dựng một lớp Circle để biểu diễn hình tròn. Trong lớp này:
//
//Thuộc tính:
//radius (bán kính): Kiểu dữ liệu double để biểu diễn bán kính của hình tròn.
//Constructor:
//Constructor mặc định để khởi tạo bán kính mặc định (ví dụ: radius = 1.0).
//Constructor có tham số để khởi tạo bán kính với giá trị do người dùng cung cấp.
//Phương thức:
//getArea(): Tính diện tích hình tròn theo công thức Area= PI * radius2
//getCircumference(): Tính chu vi hình tròn theo công thức Circumference=2 × PI × radius
//display(): Hiển thị thông tin bán kính, diện tích và chu vi của hình tròn.
//
//
//Trong phương thức main():
//
//Tạo một đối tượng Circle với constructor mặc định và hiển thị thông tin.
//Tạo một đối tượng Circle với constructor có tham số (nhập bán kính từ bàn phím hoặc gán giá trị cụ thể).
//Gọi các phương thức getArea(), getCircumference(), và display() để kiểm tra và in kết quả.
public class Circle {
    private double radius;

    //constructor mặc định
    public Circle() {
        this.radius = 1.0;
    }
    //constructor tham số
    public Circle(double radius) {
        this.radius = radius;
    }

    //method tinh dt
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //method tính cv
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //method display
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    public static void main(String[] args) {
        Circle circleMacDinh = new Circle();
        circleMacDinh.display();
        Circle circle2 = new Circle(2);
        circle2.display();
    }
}
