package bt6;
//Thuộc tính:
//x (tọa độ x) - kiểu double.
//y (tọa độ y) - kiểu double.
//Constructor:
//Constructor có tham số để khởi tạo tọa độ x và y.
//Phương thức:
//getX(): Trả về tọa độ x của điểm.
//getY(): Trả về tọa độ y của điểm.
//setX(double x): Cập nhật tọa độ x.
//setY(double y): Cập nhật tọa độ y.
//distanceTo(Point2D p): Tính khoảng cách Euclid giữa điểm hiện tại và một điểm khác p
//displayPoint(): Hiển thị tọa độ của điểm dưới dạng (x, y).
//Trong phương thức main():
//Tạo ít nhất hai đối tượng Point2D với các tọa độ khác nhau.
//Tính khoảng cách giữa hai điểm và hiển thị kết quả.
//Cập nhật tọa độ của một điểm và hiển thị lại tọa độ mới.
public class Point2D {
    private double x;
    private double y;
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
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
    // Tính khoảng cách Euclid giữa hai điểm
    public double distanceTo(Point2D p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
    public void displayPoint() {
        System.out.println("x= " + x + " y= " + y);
    }

    public static void main(String[] args) {
        Point2D point1 = new Point2D(1, 2);
        Point2D point2 = new Point2D(3, 4);
        // Tính khoảng cách giữa hai điểm
        double distance = point1.distanceTo(point2);
        System.out.println("Khoảng cách giữa hai điểm: " + distance);


        System.out.println("cap nhat toa do diem 1 thanh (3.0, 4.0)");
        point1.setX(2.0);
        point1.setY(4.0);
        System.out.println("hien thi toa do moi cua diem 1: ");
        point1.displayPoint();
        //cap nhat lai khoang cach giua 2 diem
        distance = point1.distanceTo(point2);
        System.out.println("khoang cach moi giua 2 diem=: "+distance);
    }
}
