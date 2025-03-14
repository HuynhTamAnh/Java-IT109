import java.util.Scanner;

//Nhập một số nguyên từ bàn phím.
//Sử dụng câu lệnh if-else để xác định số đó là chẵn hay lẻ.
//Trường hợp số là 0, hiển thị thông báo: "Số không phải chẵn cũng không phải lẻ".
public class Main {
    public static void main(String[] args) {
        int n;
        System.out.print("nhap n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if (n == 0) {
            System.out.println("n khong phai chan cung khong phai le");
        } else if (n % 2 == 0) {
            System.out.println("n la so chan");
        } else {
            System.out.println("n la so le");
        }

        sc.close();
    }
}