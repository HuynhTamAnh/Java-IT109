package bt5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//Viết chương trình java thực hiện các yêu cầu sau:
//
//Tạo hai HashSet
//Set1: Chứa các số nguyên {1, 2, 3, 4, 5}
//Set2: Chứa các số nguyên {4, 5, 6, 7, 8}
//Hợp hai HashSet lại(các giá trị chỉ được xuất hiện duy nhất 1 lần, không có giá trị lặp lại)
//Sắp xếp tập hợp hợp nhất theo thứ tự tăng dần và in kết quả.
//Đáp số: [1, 2, 3, 4, 5, 6, 7, 8]
public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        // Tạo Set2 chứa các số nguyên {4, 5, 6, 7, 8}
        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);

        // Hợp hai HashSet lại
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        // Sắp xếp tập hợp hợp nhất theo thứ tự tăng dần
        TreeSet<Integer> sortedSet = new TreeSet<>(unionSet);

        // In kết quả
        System.out.println(sortedSet);
    }
}
 