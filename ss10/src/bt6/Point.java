package bt6;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    // Phương thức để set cả x và y cùng lúc
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // Phương thức toString(): Trả về chuỗi mô tả điểm theo định dạng (x, y)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
