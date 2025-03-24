package bt5;

public class TestShape {
    public static void main(String[] args) {
        // Tạo đối tượng Circle
        Circle circle = new Circle(5.0);
        System.out.println("=== Thông tin Hình tròn ===");
        System.out.println("Bán kính: " + circle.getRadius());
        System.out.println("Diện tích: " + circle.getArea());

        // Tạo đối tượng Cylinder
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        System.out.println("\n=== Thông tin Hình trụ ===");
        System.out.println("Bán kính: " + cylinder.getRadius());
        System.out.println("Chiều cao: " + cylinder.getHeight());
        System.out.println("Diện tích đáy: " + cylinder.getArea());
        System.out.println("Thể tích: " + cylinder.getVolume());

        // Thử thay đổi giá trị bán kính và chiều cao
        System.out.println("\n=== Sau khi thay đổi bán kính và chiều cao ===");
        circle.setRadius(7.5);
        System.out.println("Hình tròn - Bán kính mới: " + circle.getRadius());
        System.out.println("Hình tròn - Diện tích mới: " + circle.getArea());

        cylinder.setRadius(7.5);
        cylinder.setHeight(15.0);
        System.out.println("Hình trụ - Bán kính mới: " + cylinder.getRadius());
        System.out.println("Hình trụ - Chiều cao mới: " + cylinder.getHeight());
        System.out.println("Hình trụ - Diện tích đáy mới: " + cylinder.getArea());
        System.out.println("Hình trụ - Thể tích mới: " + cylinder.getVolume());
    }
}
