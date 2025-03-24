package bt3;

import java.time.Year;

public class TestCar {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Car
        Car myCar = new Car("Toyota", "Camry", 2020);

        // Hiển thị thông tin ban đầu
        System.out.println("Thông tin xe ban đầu:");
        System.out.println("Hãng: " + myCar.getMake());
        System.out.println("Mẫu: " + myCar.getModel());
        System.out.println("Năm sản xuất: " + myCar.getYear());

        // Thay đổi thông tin thông qua các phương thức setter
        System.out.println("\nThay đổi thông tin xe:");
        myCar.setMake("Honda");
        myCar.setModel("Civic");
        myCar.setYear(2021);

        // Hiển thị thông tin sau khi thay đổi
        System.out.println("Thông tin xe sau khi thay đổi:");
        System.out.println("Hãng: " + myCar.getMake());
        System.out.println("Mẫu: " + myCar.getModel());
        System.out.println("Năm sản xuất: " + myCar.getYear());

        // Kiểm tra tính hợp lệ của năm sản xuất
        System.out.println("\nKiểm tra tính hợp lệ của năm sản xuất:");
        int currentYear = Year.now().getValue();
        myCar.setYear(currentYear + 1); // Thử đặt năm sản xuất lớn hơn năm hiện tại
        System.out.println("Năm sản xuất sau khi thử đặt giá trị không hợp lệ: " + myCar.getYear());

        myCar.setYear(1899); // Thử đặt năm sản xuất quá cũ
        System.out.println("Năm sản xuất sau khi thử đặt giá trị không hợp lệ: " + myCar.getYear());
    }
}