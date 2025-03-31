package presentation;

import business.ProductBusiness;
import entity.Product;
import validate.InputMethod;

import java.util.Scanner;

public class ProductManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = InputMethod.inputInteger(scanner);

            switch (choice) {
                case 1:
                    inputProduct();
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    sortProductsByInterest();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    changeProductStatus();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n***** JAVA-HACKATHON-05-BASIC-MENU *****");
        System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
        System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
        System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
        System.out.println("7. Thoát");
        System.out.print("Chọn chức năng (1-7): ");
    }

    private static void inputProduct() {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = InputMethod.inputInteger(scanner);

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin cho sản phẩm thứ " + (i + 1));

            Product newProduct = new Product(0, "", "", "", 0, 0, 0, false);
            newProduct.inputData();

            ProductBusiness.addProduct(newProduct);
        }
    }

    private static void displayAllProducts() {
        boolean hasProducts = false;
        for (Product product : ProductBusiness.products) {
            if (product != null) {
                product.displayData();
                hasProducts = true;
            }
        }

        if (!hasProducts) {
            System.out.println("Không có sản phẩm nào để hiển thị.");
        }
    }

    private static void sortProductsByInterest() {
        // Count number of products
        int productCount = 0;
        for (Product p : ProductBusiness.products) {
            if (p != null) productCount++;
        }

        //bubble sort
        for (int i = 0; i < productCount - 1; i++) {
            for (int j = 0; j < productCount - i - 1; j++) {
                if (ProductBusiness.products[j] != null && ProductBusiness.products[j+1] != null &&
                        ProductBusiness.products[j].getInterest() > ProductBusiness.products[j+1].getInterest()) {
                    // Swap products
                    Product temp = ProductBusiness.products[j];
                    ProductBusiness.products[j] = ProductBusiness.products[j+1];
                    ProductBusiness.products[j+1] = temp;
                }
            }
        }

        System.out.println("Đã sắp xếp các sản phẩm theo lợi nhuận tăng dần:");
        displayAllProducts();
    }

    private static void deleteProductById() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = InputMethod.inputInteger(scanner);

        boolean found = false;
        for (int i = 0; i < ProductBusiness.products.length; i++) {
            if (ProductBusiness.products[i] != null && ProductBusiness.products[i].getId() == id) {
                // Shift elements to remove the product
                for (int j = i; j < ProductBusiness.products.length - 1; j++) {
                    ProductBusiness.products[j] = ProductBusiness.products[j+1];
                }
                ProductBusiness.products[ProductBusiness.products.length - 1] = null;
                System.out.println("Đã xóa sản phẩm có mã " + id);
                found = true;
                break;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sản phẩm có mã " + id);
        }
    }

    private static void searchProductByName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Product product : ProductBusiness.products) {
            if (product != null && product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                product.displayData();
                found = true;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sản phẩm có tên: " + name);
        }
    }

    private static void changeProductStatus() {
        System.out.print("Nhập mã sản phẩm cần thay đổi trạng thái: ");
        int id = InputMethod.inputInteger(scanner);

        boolean found = false;
        for (Product product : ProductBusiness.products) {
            if (product != null && product.getId() == id) {
                // Toggle status
                product.setStatus(!product.isStatus());
                System.out.println("Đã thay đổi trạng thái sản phẩm có mã " + id);
                found = true;
                break;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sản phẩm có mã " + id);
        }
    }

    private static int findEmptyProductIndex() {
        for (int i = 0; i < ProductBusiness.products.length; i++) {
            if (ProductBusiness.products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}