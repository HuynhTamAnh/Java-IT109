package bt7;

import java.util.InputMismatchException;
import java.util.Scanner;

//Viết chương trình mô phỏng chức năng rút tiền từ một tài khoản ngân hàng.
//
//Bắt đầu với một tài khoản có số dư cố định, ví dụ: 1.000.000 đồng.
//
//Chương trình yêu cầu người dùng nhập số tiền muốn rút và xử lý các trường hợp sau bằng ngoại lệ:
//
//Tạo một tài khoản với số dư ban đầu
//Cho phép người dùng nhập số tiền cần rút
//Xử lý ngoại lệ khi:
//Người dùng nhập không phải là số → Thông báo: "Lỗi: Vui lòng nhập một số hợp lệ!"
//Số tiền rút lớn hơn số dư hiện có → Thông báo: "Lỗi: Số tiền rút vượt quá số dư!"
//Khi rút, số dư còn lại nhỏ hơn 50.000 đồng
// → Thông báo: "Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!"
//Nếu người dùng nhập số tiền phù hợp thì tiến hành trừ tiền và in thông báo ra màn hình
public class Main {
    public static void main(String[] args) {
        double soDu = 1000000;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Số dư hiện tại: " + soDu + " đồng");
        System.out.print("Nhập số tiền muốn rút: ");

        try {
            double soTienRut = scanner.nextDouble();
            //kiểm tra hợp lệ
            if (soTienRut <= 0) {
                throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0!");
            }
            if (soTienRut > soDu) {
                throw new IllegalArgumentException("Số tiền rút vượt quá số dư!");
            }
            if (soDu - soTienRut < 50000) {
                throw new IllegalArgumentException("Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }

            // Nếu hợp lệ, thực hiện rút tiền
            soDu -= soTienRut;
            System.out.println("Rút tiền thành công! Số dư còn lại: " + soDu + " đồng");

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
        }
    }
}
