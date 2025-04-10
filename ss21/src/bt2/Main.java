package bt2;

import java.util.Scanner;

//Viết chương trình yêu cầu người dùng nhập một chỉ số và lấy giá trị từ một mảng cố định. Sử dụng try-catch để xử lý lỗi nếu người dùng nhập chỉ số ngoài phạm vi.
//
//Yêu cầu:
//
//Nhập vào mảng số nguyên
//Nhập vào chỉ số phần tử của mảng
//Nếu chỉ số không nằm trong phạm vi của mảng thì thông báo lỗi
public class Main {
    public static void main(String[] args) {
        int[] mangSoNguyen = {10, 20, 30, 40, 50};

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Các phần tử trong mảng: ");
            for (int so : mangSoNguyen) {
                System.out.print(so + " ");
            }
            System.out.println();

            System.out.print("Nhập chỉ số bạn muốn truy cập: ");
            int chiSo = scanner.nextInt();

            int giaTri = mangSoNguyen[chiSo];
            System.out.println("Giá trị tại chỉ số " + chiSo + ": " + giaTri);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("LỖI: Chỉ số vượt quá giới hạn. Vui lòng nhập từ 0 đến " + (mangSoNguyen.length - 1));
        } catch (Exception e) {
            System.out.println("LỖI: Vui lòng nhập một số nguyên hợp lệ!");
        } finally {
             scanner.close();
        }
    }
}
