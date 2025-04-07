package bt3;
import java.util.LinkedHashMap;
import java.util.Map;

//Viết chương trình Java và thực hiện các yêu cầu sau:
//
//Tạo một LinkedHashMap để lưu trữ danh sách sản phẩm và giá của chúng (tên sản phẩm là khóa, giá là giá trị).
//Thêm 5 sản phẩm vào LinkedHashMap.
//In ra danh sách sản phẩm theo thứ tự mà chúng được thêm vào LinkedHashMap.
//Cập nhật giá của một sản phẩm (ví dụ: thay đổi giá của sản phẩm "Laptop").
//Xóa một sản phẩm khỏi danh sách và in lại danh sách sản phẩm sau khi xóa.
public class Main {
    public static void main(String[] args) {
        Map<String, Double> products = new LinkedHashMap<>();

        products.put("Laptop", 15000000.0);
        products.put("Smartphone", 8000000.0);
        products.put("Headphones", 1500000.0);
        products.put("Mouse", 350000.0);
        products.put("Keyboard", 550000.0);

        // In ra danh sách sản phẩm theo thứ tự khi thêm vào
        System.out.println("Danh sách sản phẩm ban đầu:");
        printProducts(products);

        // Cập nhật giá của sản phẩm "Laptop"
        products.put("Laptop", 18000000.0);
        System.out.println("\nDanh sách sản phẩm sau khi cập nhật giá Laptop:");
        printProducts(products);

        // Xóa một sản phẩm khỏi danh sách
        products.remove("Mouse");
        System.out.println("\nDanh sách sản phẩm sau khi xóa Mouse:");
        printProducts(products);
    }

    private static void printProducts(Map<String, Double> products) {
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.printf("%s: %.2f VND\n", entry.getKey(), entry.getValue());
        }
    }
}