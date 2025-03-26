package bt5;

public interface Colorable
{
    void setColor(String color);
}
class Circle implements Colorable{
    private double radius;
    private String color;
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Circle - Radius: " + radius + ", Color: " + color);
    }
}
// Lớp Rectangle
class Rectangle implements Colorable {
    private double length;
    private double width;

    private String color;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Rectangle - Length: " + length + ", Width: " + width + ", Color: " + color);
    }
}
// Lớp Square
class Square implements Colorable {
    private double side;

    private String color;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Square - Side: " + side + ", Color: " + color);
    }
}