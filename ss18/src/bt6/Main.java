package bt6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Viết chương trình Java thực hiện các yêu cầu sau:
//
//Tạo một LinkedHashMap để lưu trữ danh sách học sinh và điểm số của họ (tên học sinh là khóa, điểm số là giá trị).
//Thêm 10 học sinh vào LinkedHashMap.
//In ra danh sách học sinh và điểm số của họ theo thứ tự thêm vào.
//Tính và in ra điểm trung bình của tất cả các học sinh.
//Nếu có học sinh có điểm dưới 5, xóa học sinh đó khỏi danh sách và in lại danh sách học sinh sau khi xóa.
public class Main {
    public static void main(String[] args) {

        Map<String, Double> students = new LinkedHashMap<>();

        students.put("Nguyễn Văn A", 8.5);
        students.put("Trần Thị B", 7.0);
        students.put("Lê Văn C", 4.5);
        students.put("Phạm Thị D", 9.0);
        students.put("Hoàng Văn E", 6.5);
        students.put("Ngô Thị F", 3.5);
        students.put("Đỗ Văn G", 7.5);
        students.put("Lý Thị H", 8.0);
        students.put("Đinh Văn I", 5.0);
        students.put("Bùi Thị K", 4.0);

        // In danh sách theo thứ tự thêm vào
        System.out.println("Danh sách học sinh và điểm số:");
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Tính và in điểm trung bình của tất cả học sinh
        double sum = 0;
        for (Double score : students.values()) {
            sum += score;
        }
        double average = sum / students.size();
        System.out.println("\nĐiểm trung bình của tất cả học sinh: " + String.format("%.2f", average));

        // Tạo danh sách để lưu tên học sinh cần xóa (điểm dưới 5)
        List<String> studentsToRemove = new ArrayList<>();

        for (Map.Entry<String, Double> entry : students.entrySet()) {
            if (entry.getValue() < 5.0) {
                studentsToRemove.add(entry.getKey());
            }
        }

        // Xóa các học sinh có điểm dưới 5
        for (String student : studentsToRemove) {
            students.remove(student);
        }

        // In lại danh sách sau khi xóa
        System.out.println("\nDanh sách học sinh sau khi xóa những học sinh có điểm dưới 5:");
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}