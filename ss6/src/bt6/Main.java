package bt6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu
        Scanner scanner = new Scanner(System.in);

        // Nhập mật khẩu từ người dùng
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        scanner.close();

        // Kiểm tra tính hợp lệ của mật khẩu
        boolean isValid = checkPassword(password);

        // Hiển thị kết quả
        if (isValid) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }
    }

    // Hàm kiểm tra tính hợp lệ của mật khẩu
    public static boolean checkPassword(String password) {
        // Kiểm tra độ dài mật khẩu
        if (password.length() < 8) {
            return false;
        }

        // Kiểm tra các yêu cầu khác
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Duyệt qua từng ký tự trong mật khẩu
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            // Kiểm tra chữ cái viết hoa
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            // Kiểm tra chữ cái viết thường
            else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            // Kiểm tra chữ số
            else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            // Kiểm tra ký tự đặc biệt
            else if (isSpecialChar(c)) {
                hasSpecialChar = true;
            }
        }

        // Mật khẩu hợp lệ phải thỏa mãn tất cả các yêu cầu
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    // Hàm kiểm tra ký tự đặc biệt
    public static boolean isSpecialChar(char c) {
        // Danh sách một số ký tự đặc biệt thông dụng
        String specialChars = "@#$!%^&*()_+-=[]{}|;:,.<>?/";
        return specialChars.contains(String.valueOf(c));
    }
}