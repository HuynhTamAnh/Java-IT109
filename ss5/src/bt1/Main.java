package bt1;

import java.util.Scanner;

//Khởi tạo mảng:
//Người dùng khai báo mảng và gán giá các giá trị trực tiếp cho mảng đó
//Xử lý:
//Sử dụng một biến để lưu trữ giá trị lớn nhất, khởi tạo bằng giá trị của phần tử đầu tiên trong mảng
//Duyệt qua từng phần tử trong mảng bằng vòng lặp for, so sánh để cập nhật giá trị lớn nhất khi cần
//Đầu ra:
//Hiển thị giá trị lớn nhất trong mảng
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("kich thuoc mang: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("phan tu max: " + max);
        sc.close();
    }
}
