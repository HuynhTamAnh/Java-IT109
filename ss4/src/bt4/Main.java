package bt4;

import java.util.Scanner;

//Đầu vào:
//Chương trình sẽ yêu cầu người dùng nhập số liên tục bằng vòng lặp while.
//Nếu người dùng nhập 0, chương trình sẽ dừng lại.
//Xử lý:
//Mỗi số nhập vào sẽ được cộng dồn cho đến khi nhập vào số 0 thì ngưng nhập
//Tiến hành in kết quả tính tổng ra màn hình
//Đầu ra:
//Khi người dùng nhập 0, chương trình sẽ hiển thị tổng của tất cả các số đã nhập.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        while(true){
            System.out.print("nhap so: ");
            int n = sc.nextInt();
            if(n==0){
                System.out.println("tong cua cac so da nhap la: "+sum);
                break;
            }
            sum+=n;

        }
        sc.close();
    }
}
