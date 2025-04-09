package bt2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Viết chương trình sử dụng Stream API để tính tổng các số lẻ trong danh sách.
//
//Nhập hoặc khởi tạo danh sách các số nguyên
//Sử dụng phương thức filter() và reduce() để tính tổng các số lẻ
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numberList = Arrays.asList(numbers);
        List<Integer> oddNum=numberList.stream().filter(x -> x % 2 != 0).toList();
        System.out.println("số chẵn trong danh sách:");
        oddNum.forEach(System.out::println);

        int sumOfOddNumbers = numberList.stream()
                .filter(x -> x % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("tổng số lẻ: "+sumOfOddNumbers);
    }
}
