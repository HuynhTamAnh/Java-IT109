package bt7;
//Đầu vào:
//Một số nguyên dương N được nhập từ bàn phím.
//Xử lý:
//Sử dụng vòng lặp để duyệt qua các số từ 1 đến N.
//Với mỗi số, tính tổng bình phương các chữ số và lặp lại quá trình này cho đến khi số đó bằng 1 (số Happy) hoặc phát hiện vòng lặp vô hạn.
//Nếu số đó là số Happy, in ra số đó.
//Đầu ra:
//In danh sách các số Happy trong khoảng từ 1 đến N.
import java.util.Scanner;

public class Main {
    // Hàm kiểm tra số Happy
    public static boolean isHappy(int num) {
        // Nếu số đã về 1 hoặc 4, dừng vòng lặp
        // (4 là số bắt đầu chu trình lặp vô hạn 4->16->37->58->89->145->42->20->4)
        while (num > 1 && num != 4) {
            int sum = 0;
            // Tính tổng bình phương các chữ số
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            num = sum;
        }
        // Nếu cuối cùng num = 1 thì đây là số Happy
        return num == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương N: ");
        int n = scanner.nextInt();

        System.out.print("Các số Happy nhỏ hơn hoặc bằng " + n + " là: ");
        for (int i = 1; i <= n; i++) {
            if (isHappy(i)) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}