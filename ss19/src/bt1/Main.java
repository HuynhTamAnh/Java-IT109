package bt1;
//Sử dụng Predicate để kiểm tra xem một chuỗi có rỗng hay không.
//
//Viết một phương thức nhận vào một danh sách chuỗi
//Lọc ra các chuỗi không rỗng và in chúng

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "", "World", "Java", "", "Predicate");

        // Print the filtered non-empty strings
        printNonEmptyStrings(strings);
    }

    public static void printNonEmptyStrings(List<String> strings) {

        Predicate<String> isNotEmpty = s -> !s.isEmpty();

        // stream để trả về luồng->filter để lọc theo điều kiện-> in các chuỗi sau khi lọc
        strings.stream()
                .filter(isNotEmpty)
                .forEach(System.out::println);//tham chiếu phương thức println của đối tượng system.out
    }
}