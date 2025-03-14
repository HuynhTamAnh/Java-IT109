<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        // In phần đầu của bảng
        System.out.println("+----------------------------------------+");
        System.out.println("|             MENU CHỨC NĂNG             |");
        System.out.println("+----------------------------------------+");

        // In thông tin từng người
        System.out.println("| 1.   Đăng nhập                         |");
        System.out.println("| 2.   Đăng ký                           |");
        System.out.println("| 3.   Xem danh sách sản phẩm            |");
        System.out.println("| 4.   Tìm kiếm sản phẩm                 |");
        System.out.println("| 5.   Thêm sản phẩm vào giỏ hàng        |");
        System.out.println("| 6.   Xoá sản phẩm khỏi giỏ hàng        |");
        System.out.println("| 7.   Xem giỏ hàng                      |");
        System.out.println("| 8.   Thanh toán                        |");
        System.out.println("| 9.   Xem lịch sử mua hàng              |");
        System.out.println("| 10.  Thoát                             |");

        // In phần cuối của bảng
        System.out.println("+----------------------------------------+");
        System.out.println("|   Vui lòng chọn một chức năng 1-10:    |");
        System.out.println("+----------------------------------------+");
=======
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.print("nhap number: ");
        switch (number = sc.nextInt()) {
            case 1:
                System.out.println("chu nhat");
                break;
            case 2:
                System.out.println("thu 2");
                break;
            case 3:
                System.out.println("thu 3");
                break;
            case 4:
                System.out.println("thu 4");
                break;
            case 5:
                System.out.println("thu 5");
                break;
            case 6:
                System.out.println("thu 6");
                break;
            case 7:
                System.out.println("thu 7");
            default:
                System.out.println("so nhap vao khong hop le");
                break;
        }
        sc.close();
>>>>>>> 5830f00f22a74faa1f8a6324a3dc07ae54803b31
    }
}