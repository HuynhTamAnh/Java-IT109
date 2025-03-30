package bt8;

import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        ProductUI ui = new ProductUI();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            ui.displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ui.processAddProduct();
                    break;
                case 2:
                    ui.displayAllProducts();
                    break;
                case 3:
                    ui.searchProducts();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    ui.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
