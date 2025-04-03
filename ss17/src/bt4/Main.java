package bt4;


import java.util.TreeSet;

//Viết chương trình java thực hiện các yêu cầu sau:
//
//Tạo một TreeSet để lưu trữ các số nguyên
//Thêm các số: 45, 12, 78, 34, 23, 89 vào TreeSet
//In các phần tử trong TreeSet để kiểm tra thứ tự sắp xếp
public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(45);
        set.add(12);
        set.add(78);
        set.add(34);
        set.add(23);
        set.add(89);
        System.out.println(set);
    }
}
