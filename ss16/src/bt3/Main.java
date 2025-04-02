package bt3;
import java.util.ArrayList;
//Tạo một danh sách kiểu ArrayList lưu trữ các số nguyên và thực hiện thêm các phần tử vào danh sách.
//Thực hiện tìm phần tử lớn nhất và nhỏ nhất trong danh sách và in ra màn hình.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(5);
        numbers.add(25);
        numbers.add(8);
        numbers.add(15);
        numbers.add(3);
        numbers.add(20);

        // max
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        // min
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }

        System.out.println("List of numbers: " + numbers);
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}