package bt1;

public class Main {
    public static void main(String[] args) {
        System.out.println("\"Overloading (Nạp chồng phương thức):\\n\"\n" +
                "+ \"- Khái niệm: Định nghĩa nhiều phương thức cùng tên trong một lớp với tham số khác nhau\\n\"\n" +
                "+ \"- Thời điểm: Được giải quyết tại thời điểm biên dịch (compile-time)\\n\"\n" +
                "+ \"- Đối tượng: Xảy ra trong cùng một lớp\\n\"\n" +
                "+ \"- Tham số: Khác số lượng hoặc kiểu tham số\\n\"\n" +
                "+ \"- Mục đích: Tăng tính linh hoạt, cho phép sử dụng cùng tên phương thức với các tham số khác nhau\\n\\n\"\n" +
                "+ \"Overriding (Ghi đè phương thức):\\n\"\n" +
                "+ \"- Khái niệm: Định nghĩa lại phương thức của lớp cha trong lớp con\\n\"\n" +
                "+ \"- Thời điểm: Được giải quyết tại thời điểm chạy (runtime)\\n\"\n" +
                "+ \"- Đối tượng: Xảy ra giữa các lớp có mối quan hệ kế thừa\\n\"\n" +
                "+ \"- Tham số: Phải giữ nguyên số lượng và kiểu tham số\\n\"\n" +
                "+ \"- Mục đích: Cho phép lớp con cung cấp triển khai riêng của phương thức được kế thừa\"");
    }
}
