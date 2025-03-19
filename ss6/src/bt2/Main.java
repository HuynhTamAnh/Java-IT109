package bt2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Chương trình nhập liệu:
//Nhập một chuỗi bất kỳ từ bàn phím, đại diện cho một địa chỉ email.
//Xử lý chuỗi:
//Loại bỏ các khoảng trắng thừa nếu cần thiết.
//Kiểm tra xem chuỗi có tuân theo định dạng email hợp lệ hay không bằng cách sử dụng biểu thức chính quy (regex).
//Một email hợp lệ cần tuân theo các tiêu chí:
//Phần username: Có thể chứa các chữ cái, chữ số, dấu chấm (.), hoặc dấu gạch dưới (_).
//Ký tự @: Ngăn cách giữa phần username và domain.
//Phần domain: Chứa chữ cái hoặc chữ số, có thể chứa dấu chấm (.).
//Đuôi miền (TLD - Top-level Domain): Dài từ 2 đến 6 ký tự, chỉ chứa chữ cái.
//Kết quả:
//Nếu chuỗi nhập vào là một địa chỉ email hợp lệ, hiển thị "Email hợp lệ".
//Nếu không hợp lệ, hiển thị "Email không hợp lệ".
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập địa chỉ email:");
        String input = scanner.nextLine();

        // Loại bỏ khoảng trắng thừa nếu cần
        input = input.trim();

        // Biểu thức chính quy kiểm tra email
        // - Phần username: chữ cái, chữ số, dấu chấm (.), dấu gạch dưới (_)
        // - Ký tự @: ngăn cách username và domain
        // - Phần domain: chữ cái hoặc chữ số, có thể chứa dấu chấm (.)
        // - TLD (top-level domain): 2-6 ký tự chữ cái
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }

        scanner.close();
    }
}