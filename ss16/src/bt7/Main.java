package bt7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Tạo một danh sách kiểu ArrayList<Integer> để lưu trữ các số nguyên.
//Thêm các số nguyên vào danh sách, trong đó có một số phần tử trùng lặp.
//Tìm và in ra tất cả các phần tử xuất hiện đúng một lần.
//Tìm và in ra các phần tử bị trùng lặp kèm số lần xuất hiện của chúng.
//Hiển thị kết quả trên màn hình
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);
        numbers.add(50);
        numbers.add(10);

        System.out.println("ban đầu: " + numbers);

        Map<Integer, Integer> countMap = new HashMap<>();

        //đếm số lần xuất hiện của mỗi số
        for (Integer num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        //đếm số phần tử xuất hiện đúng 1 lần
        System.out.println("\nphần tử xuất hiện đúng 1 lần:");
        boolean foundUnique = false;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                foundUnique = true;
            }
        }
        if (!foundUnique) {
            System.out.println("0 phần tử nào xuất hiện 1 lần");
        }

        // tìm kiếm số trùng lặp và số lần xuất hiện của số đó
        System.out.println("\nsố lần xuất hiện số trùng lặp:");
        boolean foundDuplicates = false;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("số " + entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
                foundDuplicates = true;
            }
        }
        if (!foundDuplicates) {
            System.out.println("kh thấy phần tử trùng lặp nào");
        }
    }
}