package bt4;

public interface Electronic {
    void turnOn();
    void turnOff();
}

class TV implements Electronic {
    @Override
    public void turnOn() {
        System.out.println("turn on TV");
    }
    @Override
    public void turnOff() {
        System.out.println("Turning off TV.");
    }
}

class Radio implements Electronic {
    @Override
    public void turnOn() {
        System.out.println("turn on Radio");
    }
    @Override
    public void turnOff() {
        System.out.println("Turning off Radio");
    }
}