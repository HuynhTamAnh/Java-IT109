package bt2;

import java.util.Scanner;

//Yêu cầu:
//
//Nhập vào số nguyên dương n, đại diện cho kích thước của mảng. Nếu n không hợp lệ (≤ 0), thông báo "Kích thước không hợp lệ" và yêu cầu nhập lại.
//Nhập các giá trị  phần tử của mảng, giá trị có thể là số âm, số dương hoặc bằng 0
//Tính tổng các phần tử trong mảng chia hết cho 3 và hiển thị kết quả.
//Nếu không có phần tử nào chia hết cho 3, in ra "Không có số chia hết cho 3".
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nhap kich thuoc mang: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Kích thước không hợp lệ. Vui lòng nhập số nguyên dương.");
            return;
        }
        // Khai báo mảng
        int[] array = new int[n];

        // Nhập các phần tử mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        // Tính tổng các số chia hết cho 3
        int sum = 0;
        boolean hasDivisibleByThree = false;

        for (int i = 0; i < n; i++) {
            if (array[i] % 3 == 0) {
                sum += array[i];
                hasDivisibleByThree = true;
            }
        }

        // Hiển thị kết quả
        if (hasDivisibleByThree) {
            System.out.println("Tổng các phần tử chia hết cho 3= " + sum);
        } else {
            System.out.println("Không có số chia hết cho 3");
        }

        sc.close();

    }
}
