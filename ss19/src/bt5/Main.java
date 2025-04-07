package bt5;
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Nhập danh sách chuỗi
//Sử dụng để đếm số lượng chuỗi bắt đầu bằng chữ cái 'A' và có độ dài lớn hơn hoặc bằng 5 ký tự
//In số lượng ra màn hình

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        System.out.println("Nhập danh sách chuỗi (nhập 'stop' để kết thúc):");

        while (true) {
            System.out.print("Nhập chuỗi: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            stringList.add(input);
        }

        //đếm số lượng chuỗi theo đúng điều kiện
        long count = stringList.stream()
                .filter(s -> s.startsWith("A") || s.startsWith("a")) // Bắt đầu bằng A hoặc a
                .filter(s -> s.length() >= 5) // Độ dài >= 5
                .count(); // Đếm số lượng

        System.out.println("Số lượng chuỗi bắt đầu bằng chữ cái 'A' và có độ dài >= 5 ký tự: " + count);

        scanner.close();
    }
}