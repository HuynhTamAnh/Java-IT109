package bt1;
//Viết một chương trình thực hiện các thao tác sau:
//
//Tạo một HashSet để lưu trữ các số nguyên
//Thêm các số 10, 20, 30, 40, 50 vào HashSet
//In tất cả các phần tử của HashSet
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        System.out.println(set);
        for (Integer s : set) {
            System.out.println(s);
        }
    }
}
