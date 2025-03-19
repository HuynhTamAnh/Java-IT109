package bt5;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu
        Scanner scanner = new Scanner(System.in);

        // Nhập văn bản từ người dùng
        System.out.println("Nhập đoạn văn bản:");
        String text = scanner.nextLine();
        scanner.close();

        // Tách văn bản thành các từ dựa trên khoảng trắng
        String[] words = text.split("\\s+");

        // Tạo danh sách lưu các từ chứa ký tự đặc biệt
        ArrayList<String> specialWords = new ArrayList<>();

        // Kiểm tra từng từ trong văn bản
        for (String word : words) {
            // Nếu từ có chứa ký tự đặc biệt thì thêm vào danh sách
            if (hasSpecialChar(word)) {
                specialWords.add(word);
            }
        }

        // In kết quả
        if (specialWords.size() == 0) {
            System.out.println("0 (Không có ký tự đặc biệt)");
        } else {
            System.out.println(specialWords.size() + " " + specialWords);
        }
    }

    // Hàm kiểm tra xem một từ có chứa ký tự đặc biệt không
    public static boolean hasSpecialChar(String word) {
        // Kiểm tra từng ký tự trong từ
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // Nếu ký tự không phải chữ cái và không phải số thì là ký tự đặc biệt
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return true;
            }
        }

        // Nếu không tìm thấy ký tự đặc biệt nào
        return false;
    }
}