package bt1;
//Tạo một danh sách kiểu ArrayList để lưu trữ các tên sinh viên, thêm ít nhất 5 tên sinh viên vào danh sách.
//In danh sách sinh viên ra màn hình bằng cách sử dụng các kỹ thuật duyệt sau:
//Vòng lặp for.
//Vòng lặp foreach.
//Iterator.
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> danhSachSinhVien = new ArrayList<>();

        danhSachSinhVien.add("Nguyễn Văn A");
        danhSachSinhVien.add("Trần Thị B");
        danhSachSinhVien.add("Lê Hoàng C");
        danhSachSinhVien.add("Phạm Minh D");
        danhSachSinhVien.add("Hoàng Thị E");

        //  for
        System.out.println("Danh sách sinh viên (sử dụng vòng lặp for):");
        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachSinhVien.get(i));
        }

        // foreach
        System.out.println("\nDanh sách sinh viên (sử dụng vòng lặp foreach):");
        int index = 1;
        for (String sinhVien : danhSachSinhVien) {
            System.out.println(index + ". " + sinhVien);
            index++;
        }

        // Iterator
        System.out.println("\nDanh sách sinh viên (sử dụng Iterator):");
        Iterator<String> iterator = danhSachSinhVien.iterator();
        index = 1;
        while (iterator.hasNext()) {
            String sinhVien = iterator.next();
            System.out.println(index + ". " + sinhVien);
            index++;
        }
    }
}