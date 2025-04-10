package bt5;

import java.util.InputMismatchException;
import java.util.Scanner;

//Viết chương trình kiểm tra xem một số nguyên do người dùng nhập có phải là số nguyên tố hay không. Hãy xử lý các trường hợp sau bằng ngoại lệ:
//
//Người dùng nhập một giá trị không phải số
//Người dùng nhập một số âm hoặc số 0 (không hợp lệ để kiểm tra số nguyên tố)
//
//
//Yêu cầu:
//
//In thông báo lỗi nếu người dùng nhập sai
//Nếu nhập đúng, kiểm tra và thông báo kết quả
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên dương (>1): ");
            int so = scanner.nextInt();

            if (so <= 1) {
                throw new IllegalArgumentException("Số phải lớn hơn 1!");
            }

            if (laSoNguyenTo(so)) {
                System.out.println(so + " là số nguyên tố!");
            } else {
                System.out.println(so + " không phải số nguyên tố!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }

    public static boolean laSoNguyenTo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
