package bt8;
import java.util.Scanner;

//Đầu vào:
//Một số nguyên dương N được nhập từ bàn phím.
//Nếu người dùng không nhập vào số nguyên dương thì hiển thị thông báo “Số nhập vào không hợp lệ” và yêu cầu người dùng nhập lại đến khi chính xác thì ngưng
//Xử lý:
//Sử dụng vòng lặp để duyệt qua các số từ 0 đến N.
//Với mỗi số, tính số chữ số của nó (k).
//Tính tổng lũy thừa bậc k của từng chữ số.
//Nếu tổng này bằng chính số đó, thì số đó là số Armstrong.
//Đầu ra:
//In danh sách các số Armstrong trong khoảng từ 0 đến N.
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n;

            // Nhập số nguyên dương N từ bàn phím
            System.out.print("Nhập số nguyên dương N: ");

            try {
                n = scanner.nextInt();

                // Kiểm tra số nguyên dương
                if (n < 0) {
                    System.out.println("Số nhập vào không hợp lệ! Vui lòng nhập số nguyên dương.");
                    scanner.close();
                    return;
                }

                // In ra phần đầu của kết quả
                System.out.print("Các số Armstrong từ 0 đến " + n + " là: ");

                // Duyệt qua các số từ 0 đến N để tìm số Armstrong
                for (int i = 0; i <= n; i++) {
                    // Đếm số chữ số của i
                    int temp = i;
                    int countDigits = 0;

                    if (temp == 0) {
                        countDigits = 1;
                    } else {
                        while (temp > 0) {
                            countDigits++;
                            temp /= 10;
                        }
                    }

                    // Tính tổng lũy thừa các chữ số
                    temp = i;
                    int sum = 0;

                    while (temp > 0) {
                        int digit = temp % 10;

                        // Tính lũy thừa digit^countDigits
                        int power = 1;
                        for (int j = 1; j <= countDigits; j++) {
                            power *= digit;
                        }

                        sum += power;
                        temp /= 10;
                    }

                    // Kiểm tra nếu là số Armstrong thì in ra
                    if (sum == i) {
                        System.out.print(i + " ");
                    }
                }

            } catch (Exception e) {
                System.out.println("Số nhập vào không hợp lệ! Vui lòng nhập số nguyên dương.");
            }

            scanner.close();
        }

}
