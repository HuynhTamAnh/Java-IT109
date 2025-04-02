package bt6;

import java.util.ArrayList;
import java.util.LinkedHashSet;

//Tạo một danh sách kiểu ArrayList<Integer> để lưu trữ các số nguyên và thêm các phần tử vào danh sách.
//
//Thực hiện xóa các phần tử trùng lặp nhưng vẫn phải giữ nguyên thứ tự xuất hiện đầu tiên.
//
//Sử dụng phương thức này để xử lý danh sách đầu vào và in kết quả sau khi loại bỏ trùng lặp
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);
        list.add(10);

        System.out.println("mảng ban đầu: " + list);

        ArrayList<Integer> result=removeDuplicates(list);
        System.out.println("mang sau khi xoa cac phan tu trung lap: "+result);
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);

        return new ArrayList<>(set);
    }
}
