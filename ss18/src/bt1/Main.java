package bt1;
// Mô tả:
//
//Viết chương trình Java thực hiện yêu cầu sau:
//
//Tạo một HashMap để lưu trữ danh sách tên học sinh và điểm số của họ (tên là key, điểm số là value)
//Thêm 5 cặp tên-điểm vào Map
//In ra tất cả các phần tử trong Map
//Tìm và in ra điểm số của một học sinh cụ thể (ví dụ: "Nguyen Van A")

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map <String, Integer> map = new HashMap<>();
        map.put("tâm anh",0);
        map.put("thuan",100);
        map.put("hao",30);
        map.put("tran",30);
        map.put("kha",54);

        System.out.println("tất cả học sinh và điểm của họ:");
        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }

        String studentToFind = "hao";
        if(map.containsKey(studentToFind)) {
            System.out.println("\nđiểm của " + studentToFind + ": " + map.get(studentToFind));
        } else {
            System.out.println("\nhọc sinh " + studentToFind + "không tìm thấy");
        }

    }
}
