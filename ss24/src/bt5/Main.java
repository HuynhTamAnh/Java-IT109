package bt5;
//Viết một chương trình quản lý sản phẩm cho cửa hàng trực tuyến:
//
//Áp dụng nguyên tắc Single Responsibility Principle (SRP) để tách biệt việc quản lý thông tin sản phẩm, lưu trữ, và hiển thị
//Áp dụng Open/Closed Principle (OCP) để thêm các loại sản phẩm mới mà không sửa đổi mã nguồn hiện tại
public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(new Electronics(1, "Smartphone", 599.99, "Samsung", 24));
        manager.addProduct(new Clothing(2, "T-Shirt", 29.99, "M", "Cotton"));
        manager.addProduct(new Electronics(3, "Laptop", 1299.99, "Dell", 36));

        manager.displayAllProducts();

        System.out.println("Total products: " + manager.getProductCount());
    }
}