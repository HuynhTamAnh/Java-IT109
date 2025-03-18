package bt5;

import java.util.Scanner;

//Nhập liệu
//Người dùng nhập kích thước mảng và các giá trị phần tử của mảng
//Chương trình phải tìm và xuất ra:
//Giá trị của phần tử lẻ nguyên dương lớn nhất
//Giá trị của phần tử lẻ nguyên dương nhỏ nhất
//Nếu mảng không có số nguyên dương lẻ, in thông báo: "Không có phần tử lẻ trong mảng"
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("kich thuoc mang: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean hasOddPositive = false;

        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] % 2 != 0) {
                hasOddPositive = true;

                if (arr[i] < min) {
                    min = arr[i];
                }

                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        if (hasOddPositive) {
            System.out.println("phan tu le nguyen duong lon nhat: " + max);
            System.out.println("phan tu le nguyen duong nho nhat: " + min);
        } else {
            System.out.println("Khong co phan tu le trong mang");
        }

        sc.close();
    }
}