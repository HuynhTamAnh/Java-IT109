package bt5;
//Đầu vào:
//Một số nguyên dương N được nhập từ bàn phím.
//Xử lý:
//Sử dụng vòng lặp ngoài để duyệt qua tất cả các số từ 1 đến N−1.
//Sử dụng vòng lặp trong để tìm các ước và tính tổng các ước đó.
//Kiểm tra xem tổng các ước có bằng chính số đó hay không.
//Nếu có, đưa số đó vào danh sách kết quả.
//Đầu ra:
//Hiển thị tất cả các số hoàn hảo nhỏ hơn N.
//Nếu không có số hoàn hảo nào, in thông báo phù hợp.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so nguyen n: ");
        int n = sc.nextInt();

        boolean foundPerfectNumber = false;

        System.out.println("Cac so hoan hao nho hon " + n + " la:");

        // ktra tu 1 den N-1
        for (int i = 1; i < n; i++) {
            int sum = 0;

            //tim tat ca so chia het cho i va sum no
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }

            // ktra tim so hoan hao
            if (sum == i) {
                System.out.println(i);
                foundPerfectNumber = true;
            }
        }

        if (!foundPerfectNumber) {
            System.out.println("Khong co so hoan hao nao nho hon " + n);
        }

        sc.close();
    }
}