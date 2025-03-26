package bt3;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        System.out.println("animal hót: ");
        animal.makeSound();
        System.out.println("cat hót: ");
        cat.makeSound();
        System.out.println("dog hót: ");
        dog.makeSound();
    }
}
