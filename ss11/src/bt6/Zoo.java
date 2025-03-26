package bt6;

import java.util.ArrayList;
import java.util.List;

class Zoo {
    // Danh sách các động vật
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void performActions() {
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.name + ", Age: " + animal.age);
            animal.sound();
            animal.move();
            System.out.println("//////////////////"); // Dòng trắng để phân tách
        }
    }
}