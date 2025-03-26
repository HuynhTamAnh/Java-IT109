package bt4;

public class Shape {
    public double area(){
        return 0;
    }
    //tròn
    public double area(double radius){
        return Math.PI * radius * radius;
    }
    //hcn
    public double area(double height, double width){
        return width * height;
    }
}
