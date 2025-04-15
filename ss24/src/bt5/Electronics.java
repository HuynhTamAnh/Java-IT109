package bt5;

public class Electronics extends Product {
    private String brand;
    private int warrantyMonths;

    public Electronics(int id, String name, double price, String brand, int warrantyMonths) {
        super(id, name, price);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(", Brand: %s, Warranty: %d months\n", brand, warrantyMonths);
    }
}