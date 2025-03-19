package bt1;

import java.util.Scanner;

//Chương trình nhập liệu:
//Nhập một chuỗi bất kỳ từ bàn phím.
//Hỗ trợ cả chuỗi có nhiều khoảng trắng liên tiếp hoặc ở đầu/cuối chuỗi.
//Xử lý chuỗi
//Loại bỏ các khoảng trắng thừa nếu cần thiết.
//Sử dụng phương thức split() với regex "\\s+" để tách chuỗi thành các từ dựa trên khoảng trắng.
//Đếm từ
//Sau khi tách, đếm số phần tử trong mảng kết quả để xác định số từ.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = sc.nextLine();
        int count=0;
        //dùng trim để loại bỏ chỗ trống đầu và cuối
        if(s != null && !s.trim().isEmpty()) {
            // \\s+ dai dien nhieu khoang trang lien tiep
            String[] words = s.trim().split("\\s+");
            count = words.length;
        }
        System.out.println(count);
        sc.close();
    }
}
