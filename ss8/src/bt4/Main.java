package bt4;
//Yêu cầu:
//
//Chuỗi đầu vào: Tạo một chuỗi đủ dài (ít nhất 1 triệu ký tự) để dễ quan sát sự khác biệt.
//Sử dụng String initialString = "abcdefghij".repeat(100000); để khởi tạo chuỗi dài 1 triệu kí tự
//Thực hiện các thao tác trên chuỗi với cả StringBuilder và StringBuffer:
//Đảo ngược chuỗi.
//Chèn một chuỗi con vào vị trí bất kỳ.
//Xóa một đoạn trong chuỗi.
//Thay thế một đoạn trong chuỗi bằng chuỗi mới.
//Đo thời gian thực hiện từng thao tác cho cả StringBuilder và StringBuffer, sau đó so sánh kết quả.
public class Main {
    public static void main(String[] args) {
        // Tạo chuỗi đầu vào dài 1 triệu ký tự
        String initialString = "abcdefghij".repeat(100000);
        System.out.println("Độ dài chuỗi: " + initialString.length() + " ký tự");

        // 1. Đảo ngược chuỗi
        System.out.println("\n1. Đảo ngược chuỗi:");
        // StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(initialString);
        sb.reverse();
        long sbTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder: " + sbTime + " ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer(initialString);
        sbuf.reverse();
        long sbufTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuffer: " + sbufTime + " ms");

        // 2. Chèn chuỗi con
        System.out.println("\n2. Chèn chuỗi con vào vị trí bất kỳ:");
        // StringBuilder
        startTime = System.currentTimeMillis();
        sb = new StringBuilder(initialString);
        sb.insert(500000, "INSERTED_TEXT");
        sbTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder: " + sbTime + " ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        sbuf = new StringBuffer(initialString);
        sbuf.insert(500000, "INSERTED_TEXT");
        sbufTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuffer: " + sbufTime + " ms");

        // 3. Xóa một đoạn trong chuỗi
        System.out.println("\n3. Xóa một đoạn trong chuỗi:");
        // StringBuilder
        startTime = System.currentTimeMillis();
        sb = new StringBuilder(initialString);
        sb.delete(300000, 310000);
        sbTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder: " + sbTime + " ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        sbuf = new StringBuffer(initialString);
        sbuf.delete(300000, 310000);
        sbufTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuffer: " + sbufTime + " ms");

        // 4. Thay thế một đoạn trong chuỗi
        System.out.println("\n4. Thay thế một đoạn trong chuỗi:");
        // StringBuilder
        startTime = System.currentTimeMillis();
        sb = new StringBuilder(initialString);
        sb.replace(400000, 405000, "NEW_TEXT");
        sbTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder: " + sbTime + " ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        sbuf = new StringBuffer(initialString);
        sbuf.replace(400000, 405000, "NEW_TEXT");
        sbufTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuffer: " + sbufTime + " ms");
    }
}
