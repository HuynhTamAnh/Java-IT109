package bt4;

import java.util.ArrayList;

//Tạo một danh sách kiểu ArrayList lưu trữ các số nguyên và thực hiện thêm các phần tử.
//Thực hiện tính và in tổng của tất cả các phần tử trong danh sách.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(25);
        numbers.add(8);
        numbers.add(15);

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("dãy số trong array: " + numbers);
        System.out.println("tổng trong array: " + sum);

    }
}
