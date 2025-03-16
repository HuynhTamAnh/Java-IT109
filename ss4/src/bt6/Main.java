package bt6;
//Đầu vào:
//Một số nguyên N, có thể âm hoặc dương, được nhập từ bàn phím.
//Xử lý:
//Nếu số là âm, chuyển nó thành số dương.
//Sử dụng vòng lặp để tách từng chữ số của N (lấy phần dư khi chia 10).
//Cộng các chữ số lại để tính tổng.
//In ra tổng của các chữ số.
//Đầu ra:
//Hiển thị tổng các chữ số của N.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen N: ");
        int n = sc.nextInt();

        // xu ly so am
        int num = n;
        if (num < 0) {
            num = -num; // chuyen sang duong
        }

        //tinh tong
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        System.out.println("Tong cac chu so la: " + sum);

        sc.close();
    }
}