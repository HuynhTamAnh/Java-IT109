package bt4;
//Viết chương trình Java thực hiện các yêu cầu sau:
//
//Tạo một interface Shape với:
//Một phương thức mặc định(default method) area() trả về diện tích mặc định là 0.
//Một phương thức tĩnh(static method) description() in ra thông báo "This is a shape".
//Tạo lớp Circle implements Shape và ghi đè phương thức area() để tính diện tích hình tròn từ bán kính.
//Trong chương trình chính:
//Tạo một đối tượng Circle và gọi phương thức area().
//Gọi phương thức tĩnh description() để in ra mô tả chung cho các hình học.

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);

        System.out.println("Diện tích của hình tròn: " + circle.area());

        Shape.description();
    }
}

interface Shape {

    default double area() {
        return 0;
    }

    static void description() {
        System.out.println("This is a shape");
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}