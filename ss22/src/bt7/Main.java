package bt7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        taoFileData();

        try {
            List<Country> danhSachQuocGia = docFileData("data.txt");

            inDanhSachQuocGia(danhSachQuocGia);

        } catch (IOException e) {
            System.err.println("Lỗi xảy ra: " + e.getMessage());
        }
    }

    //tạo file txt theo yc
    private static void taoFileData() {
        //để có dấu "" ở trong chuỗi thì dùng \
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write("1,\"AU\", \"Australia\"\n");
            writer.write("2,\"CN\", \"China\"\n");
            writer.write("3,\"AU\", \"Australia\"\n");
            writer.write("4,\"CN\", \"China\"\n");
            writer.write("5,\"JP\", \"Japan\"\n");
            writer.write("6,\"CN\", \"China\"\n");
            writer.write("7,\"JP\", \"Japan\"\n");
            writer.write("8,\"TH\", \"Thailand\"\n");
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo file data.txt: " + e.getMessage());
        }
    }

    //đọc file và trả về danh sách Country
    private static List<Country> docFileData(String tenFile) throws IOException {
        List<Country> danhSach = new ArrayList<>();

        try (BufferedReader doc = new BufferedReader(new FileReader(tenFile))) {
            String dong;
            while ((dong = doc.readLine()) != null) {
                // Xử lý chuỗi để bỏ các dấu ngoặc kép thừa
                dong = dong.replace("\"", "");
                String[] parts = dong.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    danhSach.add(new Country(id, code, name));
                }
            }
        }

        return danhSach;
    }

    //
    private static void inDanhSachQuocGia(List<Country> danhSach) {
        System.out.println("Danh sách các quốc gia:");
        System.out.println("+--------+-----------+-------------------+");
        System.out.println("| ID     | CODE      | NAME              |");
        System.out.println("+--------+-----------+-------------------+");

        for (Country qg : danhSach) {
            System.out.printf("| ID: %-2d | CODE: %-4s | NAME: %-13s |\n",
                    qg.getId(), qg.getCode(), qg.getName());
        }

        System.out.println("+--------+-----------+-------------------+");
    }
}

