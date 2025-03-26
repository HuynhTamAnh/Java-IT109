package bt7;

class Bike extends Vehicle {
    // Ghi đè phương thức move() với hành động di chuyển chậm
    @Override
    public void move() {
        System.out.println("Xe đạp đang di chuyển chậm");
    }

    // Ghi đè phương thức sound() với âm thanh "Ring Ring"
    @Override
    public void sound() {
        System.out.println("Ring Ring");
    }
}

