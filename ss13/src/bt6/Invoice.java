package bt6;

public class Invoice {
    private Product[] products;
    private int productCount;
    private static final int MAX_PRODUCTS = 100; // Số lượng sản phẩm tối đa

    public Invoice() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    public void addProduct(String name, double price) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount] = new Product(name, price);
            productCount++;
        } else {
            System.out.println("Không thể thêm sản phẩm, đã đạt số lượng tối đa");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public double calculateTax() {
        return calculateTotal() * 0.1;
    }

    public double calculateFinalAmount() {
        return calculateTotal() + calculateTax();
    }

    public void printInvoice() {
        System.out.println("Name\tPrice");
        System.out.println("--------------------");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + "\t" + products[i].getPrice());
        }

        System.out.println("\nTotal: " + calculateTotal());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Final Amount: " + calculateFinalAmount());
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();

        invoice.addProduct("Product 1", 100);
        invoice.addProduct("Product 2", 200);
        invoice.addProduct("Product 3", 300);

        invoice.printInvoice();
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}