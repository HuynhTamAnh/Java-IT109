package bt5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Tạo một danh sách kiểu ArrayList để lưu trữ các số nguyên và thêm các phần tử vào danh sách.
//Thực hiện việc đếm số lần xuất hiện của từng phần tử có trong danh sách
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(5);
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(10);
        list.add(5);
        list.add(30);

        //dùng map
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer number : list) {
            if (countMap.containsKey(number)) {
                countMap.put(number, countMap.get(number) + 1);
            } else {
                countMap.put(number, 1);
            }
        }

        System.out.println("số trong list: " + list);
        System.out.println("số lần xuất hiện của phần tử trong arr là:");

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println("Number " + entry.getKey() + " appears " + entry.getValue() + " time(s)");
        }
    }
}
