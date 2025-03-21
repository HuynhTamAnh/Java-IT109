package bt1;

import java.util.Scanner;

//Yêu cầu:
//
//Nhập vào n đại diện cho kích thước của mảng. Nếu n không phải số nguyên dương thì thông báo “Kích thước không hợp lệ” và yêu cầu người dùng nhập lại cho đến khi hợp lệ.
//Nhập vào các phần tử mảng(có cả giá trị âm, dương và bằng 0)
//Yêu cầu in ra giá trị lớn nhất và nhỏ nhất trong mảng
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap kich thuoc mang: ");
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("Kich thuoc mang khong hop le!!");
            return;
        }
        int []arr = new int[n];

        System.out.print("nhap cac phan tu mang: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        //tìm max min
        int max=arr[0];
        int min=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("gia tri lon nhat trong mang: "+max);
        System.out.print("gia tri lon nhat trong mang: "+min);

    }
}
