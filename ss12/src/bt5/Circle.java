package bt5;

public class Circle extends Shape{
    private double radius;
    //constructor
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
