package bt3;

import java.io.*;


//Viết chương trình Java, thực hiện các chức năng như sau:
//
//Tạo ra file input.txt có nội dung văn bản tùy ý
//Thực hiện logic sao chép nội dung từ file input.txt sau đó ghi vào một file mới tên là copy.txt
//Đọc lại nội dung của file copy.txt và in ra màn hình để kiểm tra kết quả
public class Main {
    public static void main(String[] args) {
        //nội dung mẫu
        String inputContent = "Đây là nội dung mẫu trong file input.txt\n" +
                "Chương trình sẽ sao chép nội dung này sang file copy.txt\n" +
                "Sau đó hiển thị nội dung file copy.txt ra màn hình";

        try {
            FileWriter inputWriter = new FileWriter("input.txt");
            inputWriter.write(inputContent);
            inputWriter.close();
            System.out.println("Đã tạo file input.txt thành công");

            // Sao chép nội dung từ input.txt sang copy.txt
            File inputFile = new File("input.txt");
            File copyFile = new File("copy.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(copyFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Đã sao chép nội dung sang file copy.txt");

            System.out.println("\nNội dung file copy.txt:");
            BufferedReader copyReader = new BufferedReader(new FileReader(copyFile));
            while ((line = copyReader.readLine()) != null) {
                System.out.println(line);
            }
            copyReader.close();

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}