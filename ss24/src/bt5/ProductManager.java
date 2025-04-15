package bt5;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayAllProducts() {
        System.out.println("===== PRODUCT LIST =====");
        for (Product product : products) {
            product.displayInfo();
        }
        System.out.println("=======================");
    }

    public int getProductCount() {
        return products.size();
    }
}