package bt4;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Shape
        Shape shape = new Shape();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        // Kiểm tra phương thức area() với các tham số khác nhau (Overloading)
        System.out.println("Diện tích mặc định: " + shape.area());
        System.out.println("Diện tích hình tròn bán kính 5: " + shape.area(5));
        System.out.println("Diện tích hình chữ nhật 4x6: " + shape.area(4, 6));

        // Kiểm tra ghi đè phương thức (Overriding)
        System.out.println("\nDiện tích hình tròn (mặc định): " + circle.area());
        System.out.println("Diện tích hình chữ nhật (mặc định): " + rectangle.area());
    }
}