package bt5;

public class Square extends Shape {
    private double side;
    //constructor
    public Square(double side) {
        this.side = side;
    }
    @Override
    public double area() {
        return side * side;
    }
}
