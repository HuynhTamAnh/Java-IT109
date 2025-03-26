package bt3;

public abstract class Vehicle {
    // Thuộc tính (Attributes)
    public String name;
    public int speed;

    public abstract void displayInfo();

    public void start() {
        System.out.println("haha");
    }

    // Constructor
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}