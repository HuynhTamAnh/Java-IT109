package bt2;
//Triển khai mẫu thiết kế Factory Method để tạo ra các đối tượng của các loại động vật khác nhau
public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal dog = factory.getAnimal("DOG");
        System.out.print("Chó kêu: ");
        dog.speak();

        Animal cat = factory.getAnimal("CAT");
        System.out.print("Mèo kêu: ");
        cat.speak();

        Animal unknown = factory.getAnimal("BIRD");
        if (unknown == null) {
            System.out.println("Không hỗ trợ loại động vật này");
        }
    }
}
