package bt4;

public class Bicycle implements NonEngineVehicle {
    @Override
    public void move() {
        System.out.println("Bicycle is moving");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle is stopping");
    }

    @Override
    public void pedal() {
        System.out.println("Pedaling the bicycle");
    }

    @Override
    public void ringBell() {
        System.out.println("Ring ring!");
    }
}