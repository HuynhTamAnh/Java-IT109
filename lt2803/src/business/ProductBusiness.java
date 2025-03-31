package business;

import entity.Product;

public class ProductBusiness {
    public static final Product[] products = new Product[100];
    private static int productCount = 0;

    public static void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.err.println("Danh sách sản phẩm đã đầy. Không thể thêm sản phẩm mới.");
        }
    }

    public static int getProductCount() {
        return productCount;
    }
}