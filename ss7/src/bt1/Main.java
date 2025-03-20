package bt1;

import java.util.Scanner;

//Nhập dữ liệu:
//Nhập 3 chuỗi bất kỳ từ bàn phím.
//Thao tác với StringBuilder:
//Tạo một đối tượng StringBuilder.
//Sử dụng phương thức append() để nối lần lượt 3 chuỗi vừa nhập.
//Sử dụng phương thức toString() để chuyển đổi StringBuilder thành chuỗi thông thường và chuyển chuỗi này thành chữ hoa bằng toUpperCase().
//In kết quả cuối cùng:
//In chuỗi đã được chuyển đổi sang chữ hoa.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi thu nhat: ");
        String str1 = sc.nextLine();
        System.out.print("Nhap chuoi thu hai: ");
        String str2 = sc.nextLine();
        System.out.print("Nhap chuoi thu ba: ");
        String str3 = sc.nextLine();
        StringBuilder sb= new StringBuilder();

        sb.append(str1);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);

        // Chuyển đổi StringBuilder thành chuỗi thông thường
        String result = sb.toString();

        // Chuyển đổi chuỗi thành chữ hoa
        String upperCaseResult = result.toUpperCase();

        // In kết quả
        System.out.println("Chuỗi sau khi nối và chuyển đổi thành chữ hoa:");
        System.out.println(upperCaseResult);

        // Đóng Scanner
        sc.close();
    }
}
