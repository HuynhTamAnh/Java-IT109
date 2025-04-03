package bt3;

import java.util.HashSet;
import java.util.Iterator;

//Viết một chương trình thực hiện các yêu cầu sau:
//
//Tạo một HashSet chứa các số nguyên từ 1 đến 10
//Xóa các số chẵn khỏi HashSet
//In HashSet sau khi xóa
public class Main {
    public static void main(String[] args) {
        HashSet <Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if(number%2==0){
                iterator.remove();
            }
        }
        System.out.println("mang sau khi xoa so chan la: " +set);
    }


}
