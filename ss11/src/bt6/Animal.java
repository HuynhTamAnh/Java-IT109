package bt6;

public abstract class Animal {
    protected String name;
    protected int age;
    public abstract void sound();
    public abstract void move();

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }
    // Ghi đè phương thức sound()
    @Override
    public void sound() {
        System.out.println("Roar!");
    }

    // Ghi đè phương thức move()
    @Override
    public void move() {
        System.out.println("The lion is running.");
    }
}

class Elephant extends Animal {
    // Constructor
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Trumpet!");
    }

    @Override
    public void move() {
        System.out.println("The elephant is walking.");
    }
}