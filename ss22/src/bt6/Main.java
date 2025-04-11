package bt6;
//Viết chương trình Java, thực hiện các chức năng như sau:
//
//Tạo ra file input.txt có nội dung văn bản có sẵn
//Thực hiện đọc file ra và đảo ngược chuỗi đó
//Ghi nội dung chuỗi đã đảo ngược vào một file mới tên là copy.txt.
//Đọc lại file copy.txt và in ra màn hình để kiểm tra kết quả.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            //
            String noiDung = docFile("input.txt");

            //dao nguoc
            String noiDungDaoNguoc = daoNguocChuoi(noiDung);

            //Ghi nội dung đảo ngược vào copy.txt
            ghiFile("copy.txt", noiDungDaoNguoc);

            //
            String noiDungCopy = docFile("copy.txt");
            System.out.println("Nội dung đảo ngược từ file copy.txt:");
            System.out.println(noiDungCopy);

        } catch (IOException e) {
            System.err.println("Lỗi xảy ra: " + e.getMessage());
        }
    }

    private static String docFile(String tenFile) throws IOException {
        StringBuilder noiDung = new StringBuilder();
        try (BufferedReader doc = new BufferedReader(new FileReader(tenFile))) {
            String dong;
            while ((dong = doc.readLine()) != null) {
                noiDung.append(dong).append("\n");
            }
        }
        return noiDung.toString();
    }

    private static String daoNguocChuoi(String chuoi) {
        return new StringBuilder(chuoi).reverse().toString();
    }

    private static void ghiFile(String tenFile, String noiDung) throws IOException {
        try (BufferedWriter ghi = new BufferedWriter(new FileWriter(tenFile))) {
            ghi.write(noiDung);
        }
    }
}

