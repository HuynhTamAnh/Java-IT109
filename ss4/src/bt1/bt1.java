package bt1;
//Đầu vào:
//Một số nguyên dương N được nhập từ bàn phím.
//Nếu người dùng nhập số không hợp lệ (ví dụ: số âm hoặc số 0), hiển thị thông báo lỗi “Số nhập vào không hợp lệ”.
//Xử lý:
//Sử dụng vòng lặp for để tính tổng các số từ 1 đến N.
//Tính tổng bằng cách cộng dồn từng giá trị từ 1 đến N.
//Đầu ra:
//Hiển thị kết quả tính tổng trên.
import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.printf("Tổng các số từ 1 đến %d là: %d%n", n, sum);
        }
    }
}


