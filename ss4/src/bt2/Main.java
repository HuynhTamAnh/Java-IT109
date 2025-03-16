package bt2;

import java.util.Scanner;

//Đầu vào:
//Một số nguyên n được nhập từ bàn phím.
//Nếu n < 2, in ra "Không phải số nguyên tố".
//Xử lý:
//Sử dụng vòng lặp for để kiểm tra xem n có chia hết cho bất kỳ số nào từ 2 đến √n.
//Nếu tồn tại ít nhất một số mà n chia hết, thì n không phải là số nguyên tố.
//Nếu không tìm thấy số nào chia hết, thì n là số nguyên tố.
//Đầu ra:
//Nếu n là số nguyên tố, in ra: "n là số nguyên tố".
//Nếu không, in ra: "n không phải là số nguyên tố".
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so nguyen n: ");
        int n = sc.nextInt();
        if(n<2){
            System.out.println("khong phai so nguyen to");
        }
        else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    System.out.println("n khong phai so nguyen to");
                    return;
                }
            }
            System.out.println("n la so nguyen to");
        }
        sc.close();
    }
}
