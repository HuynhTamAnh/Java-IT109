package bt3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 180);

        Bike bike = new Bike("Honda", 120);
        System.out.println("car");
        car.start();
        car.displayInfo();
        System.out.println("bike");
        bike.start();
        bike.displayInfo();
    }
}