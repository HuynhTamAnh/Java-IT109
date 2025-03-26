package bt7;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng các đối tượng Vehicle
        Vehicle[] vehicles = {
                new Car(),
                new Bike(),
                new Bus()
        };

        // Duyệt qua từng phương tiện và gọi các phương thức
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.sound();
            System.out.println("------------------------");
        }
    }
}
