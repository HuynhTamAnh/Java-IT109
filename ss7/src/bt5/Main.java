package bt5;

import java.util.Scanner;

//Yêu cầu:
//
//Nhập dữ liệu:
//Nhập một chuỗi từ bàn phím.
//Xử lý chuỗi:
//Loại bỏ các khoảng trắng thừa trong câu.
//Tách câu thành từng từ bằng phương thức split().
//Sử dụng StringBuilder để đảo ngược từng từ.
//Nối các từ đã đảo ngược lại thành một câu mới với mỗi từ cách nhau bởi một khoảng trắng duy nhất.
//In ra câu mới sau khi xử lý.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập chuỗi từ bàn phím
        System.out.print("Nhập một chuỗi: ");
        String input = sc.nextLine();
        // Xử lý chuỗi và in kết quả
        String result = reverseWords(input);
        System.out.println("Chuỗi sau khi đảo ngược từng từ: " + result);
        sc.close();
    }

    public static String reverseWords(String input) {
        // Loại bỏ khoảng trắng thừa đầu, cuối và giữa các từ
        input = input.trim().replaceAll("\\s+", " ");

        // Tách chuỗi thành mảng các từ
        String[] words = input.split(" ");

        // Sử dụng StringBuilder để đảo ngược từng từ
        StringBuilder result = new StringBuilder();

        // Duyệt qua mảng từ và đảo ngược từng từ
        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse());

            // Thêm khoảng trắng giữa các từ
            if (i < words.length - 1) {
                result.append(" ");
            }

        }

        return result.toString();
    }
}
