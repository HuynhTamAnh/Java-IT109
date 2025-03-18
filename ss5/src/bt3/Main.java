package bt3;

import java.util.Scanner;

//Nhập dữ liệu mảng:
//Nhập kích thước của mảng từ người dùng
//Nhập giá trị cho từng phần tử của mảng từ bàn phím
//Xử lý:
//Sử dụng một biến countEven để lưu trữ số lượng phần tử chẵn, khởi tạo giá trị ban đầu là 0
//Duyệt qua từng phần tử trong mảng bằng vòng lặp. Nếu đó là số chẵn thì tăng countEven lên 1 đơn vị
//Đầu ra:
//Hiển thị tổng số lượng các phần tử chẵn của mảng sau khi hoàn tất tính toán
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("kich thuoc mang: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int countEven = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                countEven++;
            }
        }
        System.out.println("so lan chan: " + countEven);
        sc.close();
    }
}
