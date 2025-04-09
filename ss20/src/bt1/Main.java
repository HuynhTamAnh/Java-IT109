package bt1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Viết chương trình sử dụng Stream API để tìm tất cả các số chẵn trong danh sách số nguyên.
//
//Nhập hoặc khởi tạo một mảng số nguyên
//Sử dụng phương thức filter() để lọc các số chẵn
//In ra danh sách các số chẵn
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numberList = Arrays.asList(numbers);
        List<Integer> evenNumber=numberList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("số chẵn trong danh sách:");
        evenNumber.forEach(System.out::println);
        System.out.println("Danh sách các số chẵn: " + evenNumber);
    }
}
