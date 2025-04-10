package bt1;

import java.util.Scanner;

//Viết chương trình nhận hai số nguyên từ người dùng và thực hiện phép chia. Hãy sử dụng khối try-catch để xử lý ngoại lệ chia cho 0
//
//Yêu cầu:
//
//Nhập vào 2 số nguyên thực hiện chia hai số cho nhau
//Nếu xảy ra lỗi chia cho 0, in thông báo lỗi.
//Nếu không có lỗi, in kết quả phép chia
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("nhap so dau tien: ");
            int soChia = scanner.nextInt();

            System.out.print("nhap so thu 2: ");
            int soBiChia = scanner.nextInt();

            int result = soChia / soBiChia;
            System.out.println("kq phep chia: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: kh chia duoc cho 0.");
        } catch (Exception e) {
            System.out.println("Error: input kh hop le, nhap so nguyen");
        } finally {
            scanner.close();
        }
    }
}
