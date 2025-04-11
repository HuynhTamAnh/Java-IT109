package bt1;

import java.io.*;
import java.util.Scanner;

//Viết chương trình Java thực hiện các chức năng sau:
//
//Nhập từ bàn phím một chuỗi văn bản bất kỳ từ người dùng.
//Ghi chuỗi đó vào một file văn bản tên là output.txt.
//Sau khi ghi xong, đọc lại nội dung của file và hiển thị ra màn hình.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập chuỗi văn bản bất kỳ:");
        String inputText = scanner.nextLine();

        // Ghi chuỗi
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(inputText);
            System.out.println("Đã ghi nội dung vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        // Đọc lại nội dung file và hiển thị ra màn hình
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            System.out.println("\nNội dung file output.txt:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }

        scanner.close();
    }
}
