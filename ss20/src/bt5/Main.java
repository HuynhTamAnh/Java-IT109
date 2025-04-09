package bt5;

import java.util.List;
import java.util.Optional;

//Viết chương trình Java thực hiện các bước sau:
//
//Khởi tạo sẵn danh sách số nguyên.
//List<Integer> normalList = List.of(10, 5, 8, 20, 7);
//List<Integer> singleElementList = List.of(10);
//List<Integer> allSameList= List.of(10, 10, 10);
//Học viên sử dụng Stream API theo đúng trình tự mô tả dưới đây để tìm số lớn thứ 2:
//Loại bỏ phần tử trùng nhau(distinct())
//Sắp xếp danh sách theo thứ tự giảm dần
//Bỏ qua phần tử lớn nhất(skip(1))
//Tìm số lớn thứ 2
//Sử dụng Optional để:
//Trả về số lớn thứ hai nếu có
//Nếu không có, in ra "Không tìm thấy số lớn thứ hai"
public class Main {
    public static void main(String[] args) {
        // Khởi tạo các danh sách số nguyên
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        // Tìm số lớn thứ 2 và in kết quả cho từng danh sách
        System.out.println("Danh sách thông thường:");
        findSecondLargest(normalList);

        System.out.println("\nDanh sách có một phần tử:");
        findSecondLargest(singleElementList);

        System.out.println("\nDanh sách có các phần tử giống nhau:");
        findSecondLargest(allSameList);
    }

    private static void findSecondLargest(List<Integer> list) {
        System.out.println("Danh sách ban đầu: " + list);

        Optional<Integer> secondLargest = list.stream()
                // Loại bỏ phần tử trùng nhau
                .distinct()
                // Sắp xếp theo thứ tự giảm dần
                .sorted((a, b) -> b - a)
                // Bỏ qua phần tử lớn nhất
                .skip(1)
                // Lấy phần tử đầu tiên (số lớn thứ 2)
                .findFirst();

        // Sử dụng Optional để kiểm tra và in kết quả
        secondLargest.ifPresentOrElse(
                number -> System.out.println("Số lớn thứ hai: " + number),
                () -> System.out.println("Không tìm thấy số lớn thứ hai")
        );
    }
}