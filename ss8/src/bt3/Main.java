package bt3;

import java.util.Scanner;
import java.util.regex.Pattern;

//Nhập vào một địa chỉ email, kiểm tra tính hợp lệ theo các tiêu chí:
//Chứa duy nhất một ký tự @ và có tên miền hợp lệ (ví dụ: .com, .vn, .org).
//Bắt đầu bằng chữ cái hoặc số, chỉ chứa các ký tự hợp lệ (a-z, A-Z, 0-9, ., _, -).
//Nếu không hợp lệ, yêu cầu nhập lại.
//Nhập vào một mật khẩu, kiểm tra tính hợp lệ theo các tiêu chí:
//Ít nhất 8 ký tự.
//Chứa ít nhất một chữ hoa (A-Z), một chữ thường (a-z), một số (0-9) và một ký tự đặc biệt (@, #, $, %, !, &, *).
//Nếu không hợp lệ, yêu cầu nhập lại
//Yêu cầu đầu ra:
//Nếu email hoặc mật khẩu không hợp lệ, thông báo và yêu cầu nhập lại.
//Khi cả hai hợp lệ, hiển thị "Email và mật khẩu hợp lệ!".
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Regex patterns
        String emailRegex = "^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9.-]*\\.[a-zA-Z]{2,}$";
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!&*]).{8,}$";

        // Validate email
        String email;
        boolean validEmail = false;
        do {
            System.out.print("Nhập địa chỉ email: ");
            email = sc.nextLine();

            if (Pattern.matches(emailRegex, email)) {
                validEmail = true;
            } else {
                System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
                System.out.println("Email phải bắt đầu bằng chữ cái hoặc số, chỉ chứa các ký tự hợp lệ,");
                System.out.println("chứa duy nhất một ký tự @ và có tên miền hợp lệ (.com, .vn, .org, ...)");
            }
        } while (!validEmail);

        // Validate password
        String password;
        boolean validPassword = false;
        do {
            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();

            if (Pattern.matches(passwordRegex, password)) {
                validPassword = true;
            } else {
                System.out.println("Mật khẩu không hợp lệ! Vui lòng nhập lại.");
                System.out.println("Mật khẩu phải có ít nhất 8 ký tự và chứa ít nhất:");
                System.out.println("- Một chữ hoa (A-Z)");
                System.out.println("- Một chữ thường (a-z)");
                System.out.println("- Một số (0-9)");
                System.out.println("- Một ký tự đặc biệt (@, #, $, %, !, &, *)");
            }
        } while (!validPassword);

        System.out.println("Email và mật khẩu hợp lệ!");

        sc.close();
    }
}