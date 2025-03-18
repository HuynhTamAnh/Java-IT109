package bt4;

import java.util.Scanner;

//Nhập dữ liệu mảng:
//Nhập kích thước của mảng từ người dùng
//Nhập giá trị cho từng phần tử của mảng từ bàn phím
//Xử lý:
//Nếu mảng có kích thước rỗng thì thông báo "Kích thước rỗng"
//Thực hiện đảo ngược mảng bằng cách sử dụng vòng lặp và hoán đổi các phần tử ở đầu và cuối mảng (tức là phần tử arr[i] với arr[n-i-1], trong đó n là độ dài mảng)
//Chỉ sử dụng một mảng duy nhất, không dùng mảng phụ
//Đầu ra:
//Hiển thị mảng ban đầu và mảng sau khi đảo ngược
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("kich thuoc mang: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        if (n == 0) {
            System.out.println("kich thuoc rong");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("nhap phan tu thu " + (i + 1) + ": ");
                arr[i] = sc.nextInt();
            }

            System.out.print("mang ban dau: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n - i - 1];
                arr[n - i - 1] = temp;
            }

            System.out.print("mang sau khi dao nguoc: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}