package bt5;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng các đối tượng Shape
        Shape[] shapes = {
                new Circle(5),       // Hình tròn bán kính 5
                new Rectangle(4, 6), // Hình chữ nhật 4x6
                new Square(3)         // Hình vuông cạnh 3
        };

        // Tính diện tích và in ra từng hình
        System.out.println("Diện tích các hình:");
        for (Shape shape : shapes) {
            System.out.println(shape);  // Sử dụng phương thức toString()
        }
    }
}