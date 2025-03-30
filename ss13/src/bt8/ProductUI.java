package bt8;

import java.util.List;
import java.util.Scanner;

public class ProductUI {
    private Scanner scanner;
    private ProductService service;

    public ProductUI() {
        scanner = new Scanner(System.in);
        service = new ProductService();
    }

    public void displayMenu() {
        System.out.println("\n===== PRODUCT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Product");
        System.out.println("2. Show All Products");
        System.out.println("3. Find Product by Name");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processAddProduct() {
        System.out.println("\n----- ADD NEW PRODUCT -----");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        service.addProduct(name, price, quantity);
        System.out.println("Product added successfully!");
    }

    public void displayAllProducts() {
        System.out.println("\n----- PRODUCT INVENTORY -----");

        if (!service.hasProducts()) {
            System.out.println("No products in inventory.");
            return;
        }

        System.out.println("Name - Price - Quantity");
        System.out.println("------------------------");

        for (Product product : service.getAllProducts()) {
            System.out.println(product);
        }

        System.out.println("------------------------");
        System.out.printf("Total Inventory Value: $%.2f\n", service.calculateInventoryValue());
    }

    public void searchProducts() {
        System.out.println("\n----- SEARCH PRODUCTS -----");

        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();

        List<Product> results = service.searchProducts(name);

        if (results.isEmpty()) {
            System.out.println("Product not found.");
        } else {
            System.out.println("\nSearch results:");
            for (Product product : results) {
                System.out.println("Product found: " + product);
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
