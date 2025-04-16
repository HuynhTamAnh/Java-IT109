package bt3;
//Triển khai mẫu thiết kế Builder để tạo các đối tượng Car với các thuộc tính khác nhau.
public class Main {
    public static void main(String[] args) {
        // Tạo xe thứ nhất - Xe thể thao
        Car sportsCar = new CarBuilder()
                .setEngine("V8 Turbo")
                .setSeats(2)
                .setColor("Đỏ")
                .build();

        // Tạo xe thứ hai - Xe gia đình
        Car familyCar = new CarBuilder()
                .setEngine("V6")
                .setSeats(7)
                .setColor("Xám bạc")
                .build();

        // In thông tin các xe
        System.out.println("Xe thể thao: " + sportsCar);
        System.out.println("Xe gia đình: " + familyCar);
    }
}
