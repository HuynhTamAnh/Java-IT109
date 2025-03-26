package bt5;

public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng hình học
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Square square = new Square(3.0);

        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        circle.display();
        rectangle.display();
        square.display();
    }
}