package bt4;

public class Car implements EngineVehicle {
    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("Car is accelerating");
    }

    @Override
    public void refuel() {
        System.out.println("Car is being refueled");
    }
}