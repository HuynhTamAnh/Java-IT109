package bt7;

class Bus extends Vehicle {
    // Ghi đè phương thức move() với hành động di chuyển tốc độ trung bình
    @Override
    public void move() {
        System.out.println("Xe buýt đang di chuyển với tốc độ trung bình");
    }

    // Ghi đè phương thức sound() với âm thanh "Honk Honk"
    @Override
    public void sound() {
        System.out.println("Honk Honk");
    }
}
