package bt7;

class Car extends Vehicle {
    // Ghi đè phương thức move() với hành động di chuyển nhanh
    @Override
    public void move() {
        System.out.println("Xe ô tô đang di chuyển nhanh");
    }

    // Ghi đè phương thức sound() với âm thanh "Vroom"
    @Override
    public void sound() {
        System.out.println("é he he");
    }
}
