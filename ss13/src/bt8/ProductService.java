package bt8;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService() {
        repository = new ProductRepository();
    }

    public void addProduct(String name, double price, int quantity) {
        Product newProduct = new Product(name, price, quantity);
        repository.addProduct(newProduct);
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public List<Product> searchProducts(String name) {
        return repository.findProductsByName(name);
    }

    public boolean hasProducts() {
        return !repository.isEmpty();
    }

    public double calculateInventoryValue() {
        double total = 0;
        for (Product product : repository.getAllProducts()) {
            total += product.getTotalValue();
        }
        return total;
    }
}
