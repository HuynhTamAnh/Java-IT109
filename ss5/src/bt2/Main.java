package bt2;

import java.util.Scanner;

//Nhập dữ liệu mảng:
//Nhập kích thước của mảng từ người dùng
//Nhập giá trị cho từng phần tử của mảng từ bàn phím
//Xử lý:
//Sử dụng một biến sum để lưu trữ tổng, khởi tạo giá trị ban đầu là 0
//Duyệt qua từng phần tử trong mảng bằng vòng lặp và cộng dồn giá trị của mỗi phần tử vào biến sum
//Đầu ra:
//Hiển thị tổng các phần tử của mảng sau khi hoàn tất tính toán
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("kich thuoc mang: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("tong phan tu: " + sum);
        sc.close();
    }
}
