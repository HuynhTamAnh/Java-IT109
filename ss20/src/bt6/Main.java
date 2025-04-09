package bt6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Viết chương trình sử dụng Stream API để đếm số lần xuất hiện của mỗi phần tử trong danh sách
//
//Khởi tạo sẵn danh sách:
// List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
//Sử dụng Stream API để:
//Đếm số lần xuất hiện của từng phần tử.
//Sử dụng DateTime API để:
//In ra thời điểm thực thi chương trình, theo định dạng "dd/MM/yyyy HH:mm:ss"
public class Main {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        // Sử dụng Stream API để đếm số lần xuất hiện của từng phần tử
        Map<String, Long> countMap = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        //lấy thời điểm hiện tại
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("Thời điểm xử lý: " + formattedDateTime);
        System.out.println("{");
        countMap.forEach((key, value) -> System.out.println("    \"" + key + "\": " + value + ","));
        System.out.println("}");
    }
}