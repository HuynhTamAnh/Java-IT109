package bt6;
//Yêu cầu:
//
//Thực hiện nối chuỗi:
//Tạo một chuỗi ban đầu là "Hello".
//Sử dụng vòng lặp để nối thêm chuỗi " World" vào chuỗi ban đầu 1 triệu lần với mỗi loại: String, StringBuilder, và StringBuffer.
//Đo thời gian thực thi:
//Sử dụng System.currentTimeMillis() để đo thời gian bắt đầu và kết thúc cho mỗi loại xử lý.
//Xuất kết quả:
//In ra thời gian thực hiện của từng loại nối chuỗi.
//Ghi nhận xét về hiệu suất và trường hợp sử dụng phù hợp của mỗi loại.
public class Main {
    public static void main(String[] args) {
        // Số lần lặp lại
        int n = 1000000;

        // Thực hiện nối chuỗi bằng String
        long startTimeString = System.currentTimeMillis();
        String str = "Hello";
        for (int i = 0; i < n; i++) {
            str += " World";
        }
        long endTimeString = System.currentTimeMillis();
        long timeString = endTimeString - startTimeString;

        // Thực hiện nối chuỗi bằng StringBuilder
        long startTimeStringBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < n; i++) {
            sb.append(" World");
        }
        long endTimeStringBuilder = System.currentTimeMillis();
        long timeStringBuilder = endTimeStringBuilder - startTimeStringBuilder;

        // Thực hiện nối chuỗi bằng StringBuffer
        long startTimeStringBuffer = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < n; i++) {
            sbf.append(" World");
        }
        long endTimeStringBuffer = System.currentTimeMillis();
        long timeStringBuffer = endTimeStringBuffer - startTimeStringBuffer;

        // In kết quả
        System.out.println("Thời gian thực thi khi nối chuỗi bằng String: " + timeString + " ms");
        System.out.println("Thời gian thực thi khi nối chuỗi bằng StringBuilder: " + timeStringBuilder + " ms");
        System.out.println("Thời gian thực thi khi nối chuỗi bằng StringBuffer: " + timeStringBuffer + " ms");
    }
}

