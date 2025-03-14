import java.util.Scanner;

//Kỹ thuật lập trình:
//Sử dụng lệnh điều khiển if-else
//Chương trình phải xử lý được trường hợp ba số bằng nhau
//Không sử dụng thư viện hoặc phương pháp sẵn có để tìm giá trị lớn nhất
//Tính năng chương trình:
//Chương trình yêu cầu người dùng nhập ba số nguyên từ bàn phím
//Nếu ba số bằng nhau, hiển thị thông báo “Ba số nguyên bằng nhau”
//Nếu không, hiển thị số lớn nhất với thông báo cụ thể
public class Main {
    public static void main(String[] args) {
        int a, b;
        System.out.print("nhap a: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        System.out.print("nhap b: ");
        b = sc.nextInt();
        System.out.print("Nhap c: ");
        int c = sc.nextInt();
        sc.close();
        if (a == b && a == c) {
            System.out.println("a, b, c la so chan");
        } else {
            if (a > b && a > c) {
                System.out.println("a la so lon nhat");
            } else if (b > a && b > c) {
                System.out.println("b la so lon nhat");
            } else {
                System.out.println("c la so lon nhat");
            }
        }
    }
}