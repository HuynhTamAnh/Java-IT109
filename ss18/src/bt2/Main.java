package bt2;

import java.util.HashMap;
import java.util.Map;

//Viết chương trình Java thực hiện các yêu cầu sau:
//
//Tạo một Map lưu trữ các sản phẩm và giá của chúng (tên sản phẩm là khóa, giá là giá trị)
//Kiểm tra xem sản phẩm "Laptop" có trong Map hay không và thông báo tương ứng
//Kiểm tra xem có sản phẩm nào có giá trị bằng 1000 hay không và thông báo tương ứng
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("lap", 10000000);
        map.put("mouse",1000000);
        map.put("keyBoard",2000000);

        //in giá và sản phẩm
        System.out.println("in giá và sản phẩm: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " VND");
        }
        // Kiểm tra xem sản phẩm "Laptop" có trong Map hay không
        String productToCheck = "Laptop";
        if (map.containsKey(productToCheck)) {
            System.out.println("\nSản phẩm '" + productToCheck + "' có trong danh sách với giá: "
                    + map.get(productToCheck) + " VND");
        } else {
            System.out.println("\nSản phẩm '" + productToCheck + "' không có trong danh sách.");
        }
    }
}
