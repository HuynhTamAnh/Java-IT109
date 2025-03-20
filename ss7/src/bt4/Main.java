package bt4;

import java.util.Scanner;

//Yêu cầu:
//Nhập dữ liệu:
//Nhập một chuỗi từ bàn phím.
//Xử lý chuỗi:
//Chuyển chuỗi về dạng chữ thường để tránh phân biệt chữ hoa/chữ thường.
//Dùng StringBuilder để tạo chuỗi đảo ngược của chuỗi ban đầu bằng phương thức reverse().
//So sánh chuỗi ban đầu và chuỗi đảo ngược.
//Xuất kết quả:
//Nếu hai chuỗi giống nhau, in ra: "Chuỗi đối xứng."
//        Ngược lại, in ra: "Chuỗi không đối xứng."
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String chuoi = sc.nextLine();

        // Chuyển chuỗi về dạng chữ thường để tránh phân biệt chữ hoa/chữ thường
        String lowerCaseInput = chuoi.toLowerCase();

        // Dùng StringBuilder để tạo chuỗi đảo ngược của chuỗi ban đầu
        StringBuilder sb = new StringBuilder(lowerCaseInput);
        String reversedString = sb.reverse().toString();

        // Kiểm tra xem chuỗi ban đầu có giống chuỗi đảo ngược không
        boolean isDaoNguoc = lowerCaseInput.equals(reversedString);

        // In kết quả
        System.out.println("Chuỗi đã nhập: " + chuoi);
        System.out.println("Chuỗi đã đảo ngược (đã chuyển về chữ thường): " + reversedString);

        if (isDaoNguoc) {
            System.out.println("\n=> Kết luận: Chuỗi đối xứng.");
        } else {
            System.out.println("\n=> Kết luận: Chuỗi không đối xứng.");
        }

        sc.close();
    }
}
