package bt3;

import java.util.Scanner;

//Yêu cầu:
//
//Nhập dữ liệu:
//Nhập một chuỗi bất kỳ từ bàn phím.
//Thao tác với StringBuilder:
//Tạo một đối tượng StringBuilder với chuỗi vừa nhập.
//Sử dụng phương thức reverse() để đảo ngược chuỗi.
//Xuất kết quả:
//In chuỗi ban đầu.
//In chuỗi đã được đảo ngược.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần đảo ngược: ");
        String input = sc.nextLine();

        // Tạo đối tượng StringBuilder từ chuỗi nhập vào
        StringBuilder sb = new StringBuilder(input);

        // Đảo ngược chuỗi
        StringBuilder reversedSb = sb.reverse();

        // In kết quả
        System.out.println("Chuỗi ban đầu: " + input);
        System.out.println("Chuỗi đã đảo ngược: " + reversedSb.toString());

        sc.close();
    }
}
