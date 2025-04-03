package bt6;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//Viết chương trình java thực hiện các yêu cầu sau:
//
//Tạo hai HashSet:
//Set1: Chứa các số nguyên {10, 20, 30, 40}
//Set2: Chứa các số nguyên {30, 40, 50, 60}
//Tìm giao của hai HashSet và in ra các phần tử giao nhau (điểm chung của 2 collection set)
//Sắp xếp các phần tử theo thứ tự tăng dần
//Đáp số: [30,40]
public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);

        // Tạo Set2 chứa các số nguyên {4, 5, 6, 7, 8}
        Set<Integer> set2 = new HashSet<>();
        set2.add(30);
        set2.add(40);
        set2.add(50);
        set2.add(60);

        // Tìm giao của hai HashSet
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        // Sắp xếp tăng dần
        TreeSet<Integer> sortedIntersection = new TreeSet<>(intersectionSet);

        System.out.println(sortedIntersection);
    }
}
