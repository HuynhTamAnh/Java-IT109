package bt5;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // toString for easy printing
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class ProductManager {
    private ArrayList<Product> products;
    private Scanner scanner;

    // Constructor
    public ProductManager() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        int id = products.size() + 1;
        Product newProduct = new Product(id, name, price);
        products.add(newProduct);
        System.out.println("Product added successfully.");
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void findProduct() {
        System.out.print("Enter product name to find: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Product found: " + product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAllProducts();
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Product Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. Show All Products");
        System.out.println("3. Find Product");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.run();
    }
}