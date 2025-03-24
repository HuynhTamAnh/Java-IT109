package bt3;
//Bài tập yêu cầu sinh viên xây dựng một lớp Rectangle để biểu diễn hình chữ nhật. Trong lớp này:
//
//Các thuộc tính length và width (kiểu double) đại diện cho chiều dài và chiều rộng của hình chữ nhật.
//Cung cấp 2 constructor sau:
//Khởi tạo hình chữ nhật với kích thước mặc định (chiều dài và chiều rộng = 1).
//Khởi tạo hình chữ nhật với chiều dài và chiều rộng do người dùng cung cấp.
//Cài đặt các phương thức:
//getArea(): Tính và trả về diện tích của hình chữ nhật.
//getPerimeter(): Tính và trả về chu vi của hình chữ nhật.
//display(): Hiển thị thông tin về chiều dài, chiều rộng, diện tích và chu vi.
//Trong phương thức main():
//Sinh viên tạo đối tượng Rectangle với cả constructor mặc định và constructor có tham số.
//Gọi các phương thức để kiểm tra tính đúng đắn và in kết quả ra màn hình.
public class Rectangle {
    private double length;
    private double width;

    //tạo constructor mặc định
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    //tạo constructor có tham số
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    //method tinh dien tich
    public double getArea() {
        return length * width;
    }
    //method tính chu vi
    public double getPerimeter() {
        return (length + width)*2;
    }
    //method hien thi chieu dai, rong, dt, cv
    public void display() {
        System.out.println("Hình chữ nhật có:");
        System.out.println("- Chiều dài: " + length);
        System.out.println("- Chiều rộng: " + width);
        System.out.println("- Diện tích: " + getArea());
        System.out.println("- Chu vi: " + getPerimeter());
    }

    public static void main(String[] args) {
        Rectangle rectangleMacDinh = new Rectangle();
        rectangleMacDinh.display();
        Rectangle rectangle2 = new Rectangle(3,2.5);
        rectangle2.display();
    }
}
