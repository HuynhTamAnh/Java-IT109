package bt5;

import java.util.*;
import java.util.stream.Collectors;

//Viết chương trình Java thực hiện các yêu cầu sau:
//
//Tạo một Map lưu trữ danh sách tên sản phẩm và giá của chúng, với Key là tên sản phẩm, Value là giá sản phẩm.
//Lọc ra các sản phẩm có giá trong khoảng từ 500 đến 1500.
//Sắp xếp các sản phẩm đã lọc theo giá (tăng dần).
//In ra danh sách các sản phẩm sau khi lọc và sắp xếp theo định dạng sau:
//Tên sản phẩm: [Tên sản phẩm] - Giá: [Giá]
public class Main {
    public static void main(String[] args) {

        Map<String, Double> products = new HashMap<>();

        products.put("Laptop", 1200.0);
        products.put("Smartphone", 800.0);
        products.put("Headphones", 300.0);
        products.put("Monitor", 500.0);
        products.put("Keyboard", 100.0);
        products.put("Mouse", 50.0);
        products.put("Tablet", 600.0);
        products.put("Printer", 450.0);
        products.put("External HDD", 700.0);
        products.put("Graphics Card", 1500.0);

        System.out.println("Danh sách sản phẩm ban đầu:");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }

        //
        List<Map.Entry<String, Double>> filteredAndSorted = new ArrayList<>();

        // Lọc
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            if (entry.getValue() >= 500 && entry.getValue() <= 1500) {
                filteredAndSorted.add(entry);
            }
        }

        // Sắp xếp các sản phẩm đã lọc theo giá tăng dần
        Collections.sort(filteredAndSorted, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        System.out.println("\nDanh sách sản phẩm sau khi lọc (500-1500) và sắp xếp (tăng dần):");
        for (Map.Entry<String, Double> entry : filteredAndSorted) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }
    }
}