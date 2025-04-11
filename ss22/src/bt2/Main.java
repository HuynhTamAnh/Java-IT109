package bt2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Viết chương trình Java thực hiện các bước sau:
//
//Nhập vào tên tệp từ bàn phím (ví dụ: data.txt).
//Sử dụng lớp File để kiểm tra xem tệp có tồn tại không.
//Nếu tệp chưa tồn tại, thì tạo mới tệp đó và thông báo “Tệp đã được tạo!”.
//Nếu tệp đã tồn tại, thì in thông báo “Tệp đã tồn tại!”.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên tệp (ví dụ: data.txt): ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        // Kiểm tra file tồn tại hay kh
        if (file.exists()) {
            System.out.println("Tệp đã tồn tại!");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("Tệp đã được tạo!");
                } else {
                    System.out.println("Không thể tạo tệp!");
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi tạo tệp: " + e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Không có quyền tạo tệp: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
