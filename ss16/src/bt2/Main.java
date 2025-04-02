package bt2;
//Tạo một danh sách kiểu ArrayList để lưu trữ các số nguyên, và thực hiện thêm 10 phần tử bất kì vào danh sách.
//Thực hiện xóa các số chia hết cho 3 khỏi danh sách
//In danh sách trước khi xóa và sau khi xóa.
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> danhSachSo = new ArrayList<>();

        danhSachSo.add(1);
        danhSachSo.add(3);
        danhSachSo.add(5);
        danhSachSo.add(6);
        danhSachSo.add(7);
        danhSachSo.add(9);
        danhSachSo.add(10);
        danhSachSo.add(12);
        danhSachSo.add(14);
        danhSachSo.add(15);

        //trước khi xóa
        System.out.println("Danh sách số trước khi xóa:");
        for (Integer so : danhSachSo) {
            System.out.print(so + " ");
        }
        System.out.println();

        //xóa các số chia hết cho 3 khỏi danh sách
        Iterator<Integer> iterator = danhSachSo.iterator();
        while (iterator.hasNext()) {
            Integer so = iterator.next();
            if (so % 3 == 0) {
                iterator.remove();
            }
        }

        //sau khi xóa
        System.out.println("\nDanh sách số sau khi xóa các số chia hết cho 3:");
        for (Integer so : danhSachSo) {
            System.out.print(so + " ");
        }
        System.out.println();
    }
}