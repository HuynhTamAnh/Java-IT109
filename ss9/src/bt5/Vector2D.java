package bt5;
//Hãy xây dựng một lớp Vector2D trong Java để biểu diễn vector trong không gian 2D với hai tọa độ (x, y). Lớp này cần có các phương thức thực hiện các phép toán vector phổ biến.
//
//
//
//Lớp Vector2D gồm:
//
//Thuộc tính:
//x (Tọa độ x của vector) - kiểu double.
//y (Tọa độ y của vector) - kiểu double.
//Constructor:
//Constructor có tham số để khởi tạo tọa độ x và y.
//Phương thức:
//calculateMagnitude(): Tính độ dài của vector
//add(Vector2D v): Trả về vector tổng của vector hiện tại và v
//subtract(Vector2D v): Trả về vector hiệu giữa vector hiện tại và v.
//dotProduct(Vector2D v): Tính tích vô hướng giữa vector hiện tại và v
//displayVector(): Hiển thị tọa độ của vector dưới dạng (x, y).
//Trong phương thức main():
//
//Tạo ít nhất hai vector Vector2D với tọa độ khác nhau.
//Hiển thị thông tin của các vector.
//Tính và hiển thị độ dài, tổng, hiệu, tích vô hướng giữa hai vector
public class Vector2D {
    public double x;
    public double y;
    //constructor
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //method tinh do dai vector
    public double calculateMagnitude() {
        return Math.sqrt(x*x+y*y);
    }
    //method cong hai vector
    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x+v.x,this.y+v.y);
    }
    //method trừ 2 vector
    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x-v.x,this.y-v.y);
    }
    //tính tích vô hướng
    public double dotProduct(Vector2D v) {
        return this.x*v.x+this.y*v.y;
    }
    //hiển thị vector
    public void displayVector() {
        System.out.println("(" + x + ", " + y + ")");
    }
    //getter cho x
    public double getX() {
        return x;
    }
    //getter cho y
    public double getY() {
        return y;
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3,3);
        Vector2D v2 = new Vector2D(1,2);

        //hien thi thong tin vector
        System.out.println("vector v1: ");
        v1.displayVector();
        System.out.println("vector v2: ");
        v2.displayVector();

        //tinh va hien thi do dai
        System.out.println("do dai cua v1: " + v1.calculateMagnitude());
        System.out.println("do dai cua v2: " + v2.calculateMagnitude());

        //tinh va hien thi tong
        Vector2D sum= v1.add(v2);
        System.out.println("tong v1 va v2= ");
        sum.displayVector();

        //tinh va hien thi hieu
        Vector2D difference = v1.subtract(v2);
        System.out.println("hieu v1 va v2= ");
        difference.displayVector();

        //tinh va hien thi tich vo huong
        double dotProduct = v1.dotProduct(v2);
        System.out.println("hieu v1 va v2= "+ dotProduct);
    }
}
