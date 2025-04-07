package bt6;
//Tạo Interface StringProcessor có:
//1 phương thức trừu tượng(abstract) processString(String input) để xử lý chuỗi.
//1 phương thức mặc định(default) printList(List<String> list) để in danh sách chuỗi.
//Cài đặt phương thức trong main():
//Nhập hoặc khởi tạo sẵn một mảng các chuỗi.
//Trong phương thức main(), sử dụng Lambda Expression để cài đặt phương thức processString() của interface StringProcessor.
//Chuyển tất cả các ký tự trong chuỗi thành chữ hoa
//Thêm " - TECHNICAL" vào sau mỗi ký tự đã in hoa
//Sử dụng phương thức default printList(List<String> list) từ interface để in danh sách chuỗi sau khi đã xử lý.
//Kiểm tra lại

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"java", "python", "javascript", "html", "css"};
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));

        System.out.println("Danh sách chuỗi ban đầu:");
        for (String s : stringList) {
            System.out.println(s);
        }

        // Lambda Expression cài phương thức processString
        StringProcessor processor = (input) -> {
            // Chuyển tất cả ký tự thành chữ hoa
            String upperCase = input.toUpperCase();

            return upperCase + " - TECHNICAL";
        };

        // Tạo danh sách mới để lưu các chuỗi sau khi xử lý
        List<String> processedList = new ArrayList<>();

        // Xử lý từng chuỗi trong danh sách ban đầu
        for (String str : stringList) {
            processedList.add(processor.processString(str));
        }

        System.out.println("\nDanh sách chuỗi sau khi xử lý:");
        // Sử dụng default printList để in list đã xử lý
        processor.printList(processedList);
    }
}

// Tạo Interface StringProcessor
interface StringProcessor {
    //trừu tượng
    String processString(String input);

    default void printList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}