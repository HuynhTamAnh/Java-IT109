package bt4;
//Xây dựng một hệ thống phương tiện giao thông. Các phương tiện khác nhau (ô tô, xe đạp) chỉ cần triển khai các hành vi liên quan đến chúng, không bị ép buộc triển khai các phương thức không cần thiết
//Yêu cầu:
//
//Tách interface Vehicle thành các interface nhỏ như EngineVehicle, NonEngineVehicle
//Triển khai tạo lớp Car, Bicycle kế thừa interface tương ứng
//Tạo lớp Main kiểm thử chức năng đã làm
public class Main {
    public static void main(String[] args) {
        EngineVehicle car = new Car();
        car.startEngine();
        car.accelerate();
        car.move();
        car.stop();
        car.refuel();

        System.out.println("--------------------");

        NonEngineVehicle bicycle = new Bicycle();
        bicycle.pedal();
        bicycle.move();
        bicycle.ringBell();
        bicycle.stop();

        // in 2 cái lun
        System.out.println("--------------------");
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bicycle();
        vehicle1.move();
        vehicle2.move();
    }
}