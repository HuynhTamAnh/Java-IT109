package bt5;

//import java.io.BufferedWriter;

//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Tạo ra file input.txt có nội dung tên các cầu thủ như sau:
//Đọc nội dung của file input.txt.
//Tìm từ có độ dài lớn nhất (tức là tên dài nhất), và in ra màn hình:
//Tên cầu thủ dài nhất
//Độ dài của tên đó
import java.io.*;
public class Main {
    public static void main(String[] args) {
        // Tạo file input.txt với danh sách cầu thủ
        String[] players = {
                "Nguyen Quang Hai",
                "Luong Xuan Truong",
                "Doan Van Hau",
                "Nguyen Cong Phuong",
                "Tran Dinh Trong",
                "Que Ngoc Hai",
                "Bui Tien Dung",
                "Phan Van Duc"
        };

        try {
            // Ghi danh sách cầu thủ vào file input.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
            for (String player : players) {
                writer.write(player);
                writer.newLine();
            }
            writer.close();
            System.out.println("Đã tạo file input.txt thành công");

            // Đọc file và tìm tên dài nhất
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String longestName = "";
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.length() > longestName.length()) {
                    longestName = currentLine;
                }
            }
            reader.close();

            System.out.println("\nKết quả:");
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên: " + longestName.length() + " ký tự");

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
