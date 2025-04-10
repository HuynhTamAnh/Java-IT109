package bt6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Viết chương trình yêu cầu người dùng nhập vào một danh sách các chuỗi
//Chương trình sẽ duyệt qua từng chuỗi và cố gắng chuyển đổi nó sang kiểu số nguyên bằng Integer.parseInt().
//Nếu một chuỗi chuyển đổi thành công, lưu số nguyên vào danh sách hợp lệ.
//Nếu không chuyển được (ví dụ chuỗi là chữ hoặc ký tự đặc biệt), thì bắt ngoại lệ và ghi nhận là không hợp lệ
//In ra số lượng chuỗi hợp lệ và không hợp lệ
//In ra danh sách chuỗi hợp lệ
//Yêu cầu:
//
//Đếm số lượng chuỗi hợp lệ và không hợp lệ
//In danh sách các số nguyên đã chuyển đổi thành công
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> danhSachHopLe = new ArrayList<>();
        int soLuongKhongHopLe = 0;

        System.out.println("Nhập các chuỗi (cách nhau bằng dấu cách, kết thúc bằng Enter):");
        String[] cacChuoi = scanner.nextLine().split(" ");

        for (String chuoi : cacChuoi) {
            try {
                int so = Integer.parseInt(chuoi);
                danhSachHopLe.add(so);
            } catch (NumberFormatException e) {
                // Nếu không chuyển được, tăng biến đếm
                soLuongKhongHopLe++;
            }
        }

        System.out.println("\nKết quả:");
        System.out.println("Số lượng chuỗi hợp lệ: " + danhSachHopLe.size());
        System.out.println("Số lượng chuỗi không hợp lệ: " + soLuongKhongHopLe);
        System.out.println("Danh sách số nguyên hợp lệ: " + danhSachHopLe);

        scanner.close();
    }
}
