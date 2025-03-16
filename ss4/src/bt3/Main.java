package bt3;

import java.util.Scanner;

//Đầu vào:
//Một số nguyên dương n được nhập từ bàn phím.
//Nếu n không phải là số nguyên dương thì thông báo “Số nhập vào không hợp lệ”
//Xử lý:
//Sử dụng vòng lặp for để lặp từ 1 đến 10.
//Tính giá trị của mỗi phép nhân n x i, với i chạy từ 1 đến 10.
//Hiển thị kết quả của từng phép nhân dưới dạng: n x i = kết quả.
//Đầu ra:
//In bảng cửu chương của n, với mỗi dòng là một phép nhân.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so nguyen n: ");
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n>0){
                for(int i=1;i<=10;i++){
                    System.out.printf("%d x %d = %d%n",n,i,n*i);
                }
            }else{
                System.out.println("so nhap vao khong hop le");
            }
        }else{
            System.out.println("so nhap vao khong hop le");
        }
        sc.close();
    }
}
