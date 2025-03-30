package bt8;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private ArrayList<Product> products;

    public ProductRepository() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> findProductsByName(String name) {
        List<Product> foundProducts = new ArrayList<Product>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
