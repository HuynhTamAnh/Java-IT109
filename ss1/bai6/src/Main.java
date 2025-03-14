<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        System.out.println("Tôi sẽ giải đáp các câu hỏi của bạn về Java:\n" +
                "\n" +
                "### JDK, JRE và JVM trong hệ sinh thái Java\n" +
                "\n" +
                "**JDK (Java Development Kit):**\n" +
                "- Là bộ công cụ phát triển Java hoàn chỉnh\n" +
                "- Bao gồm JRE và thêm các công cụ phát triển như trình biên dịch (javac), trình gỡ lỗi, và các công cụ khác (jar, javadoc)\n" +
                "- Dành cho lập trình viên để phát triển ứng dụng Java\n" +
                "\n" +
                "**JRE (Java Runtime Environment):**\n" +
                "- Môi trường thực thi Java\n" +
                "- Bao gồm JVM và các thư viện Java chuẩn \n" +
                "- Dành cho người dùng muốn chạy ứng dụng Java (không cần phát triển)\n" +
                "\n" +
                "**JVM (Java Virtual Machine):**\n" +
                "- Máy ảo Java, thực thi bytecode Java\n" +
                "- Cung cấp môi trường để chạy chương trình Java đã được biên dịch\n" +
                "- Chịu trách nhiệm quản lý bộ nhớ, thu gom rác, và các hoạt động cấp thấp khác\n" +
                "\n" +
                "**Mối quan hệ:**\n" +
                "- JDK > JRE > JVM (JDK chứa JRE và JRE chứa JVM)\n" +
                "- Quá trình: Mã nguồn Java → JDK (biên dịch) → Bytecode → JRE (cung cấp môi trường) → JVM (thực thi)\n" +
                "\n" +
                "### \"Write once, run anywhere\" trong Java\n" +
                "\n" +
                "Khái niệm này thể hiện tính di động của Java, cho phép chương trình được viết một lần có thể chạy trên bất kỳ nền tảng nào hỗ trợ Java.\n" +
                "\n" +
                "**Cơ chế giúp Java chạy trên nhiều nền tảng:**\n" +
                "1. **Biên dịch ra Bytecode:** Code Java được biên dịch thành bytecode thay vì mã máy\n" +
                "2. **JVM đặc thù theo nền tảng:** Mỗi hệ điều hành có JVM riêng hiểu được bytecode\n" +
                "3. **Thông dịch tại runtime:** JVM thông dịch bytecode thành mã máy phù hợp với từng nền tảng\n" +
                "\n" +
                "Nhờ vậy, chương trình Java không cần biên dịch lại khi chuyển đổi từ Windows sang Linux, MacOS hoặc các nền tảng khác.\n" +
                "\n" +
                "### Cài đặt và chạy chương trình Java với IntelliJ IDEA\n" +
                "\n" +
                "1. **Cài đặt JDK:**\n" +
                "   - Tải và cài đặt JDK từ Oracle hoặc OpenJDK\n" +
                "   - Thiết lập biến môi trường JAVA_HOME (nếu cần)\n" +
                "\n" +
                "2. **Cài đặt IntelliJ IDEA:**\n" +
                "   - Tải IntelliJ IDEA từ website JetBrains (Community hoặc Ultimate)\n" +
                "   - Cài đặt theo hướng dẫn\n" +
                "\n" +
                "3. **Tạo dự án Java cơ bản:**\n" +
                "   - Khởi động IntelliJ IDEA\n" +
                "   - Chọn \"Create New Project\"\n" +
                "   - Chọn \"Java\" từ danh sách bên trái\n" +
                "   - Chọn Project SDK (JDK đã cài đặt)\n" +
                "   - Chọn mẫu dự án \"Command Line App\" (hoặc không chọn mẫu nào)\n" +
                "   - Đặt tên và vị trí cho dự án, nhấn \"Finish\"\n" +
                "\n" +
                "4. **Tạo class đầu tiên:**\n" +
                "   - Chuột phải vào thư mục \"src\" → New → Java Class\n" +
                "   - Đặt tên cho class, ví dụ: \"HelloWorld\"\n" +
                "   - Thêm phương thức main:\n" +
                "   ```java\n" +
                "   public static void main(String[] args) {\n" +
                "       System.out.println(\"Hello, World!\");\n" +
                "   }\n" +
                "   ```\n" +
                "\n" +
                "5. **Chạy chương trình:**\n" +
                "   - Nhấn chuột phải vào file → Run 'HelloWorld.main()'\n" +
                "   - Hoặc nhấn nút Run (biểu tượng tam giác xanh)\n" +
                "   - Kết quả sẽ hiển thị ở cửa sổ Run bên dưới\n" +
                "\n" +
                "### Các phiên bản Java\n" +
                "\n" +
                "**Java SE (Standard Edition):**\n" +
                "- Nền tảng cơ bản của Java\n" +
                "- Chứa các API cốt lõi cho lập trình Java\n" +
                "- Mục đích: Phát triển ứng dụng desktop, console và ứng dụng nhỏ\n" +
                "- Đối tượng: Lập trình viên phát triển ứng dụng thông thường\n" +
                "\n" +
                "**Java EE (Enterprise Edition):**\n" +
                "- Mở rộng từ Java SE\n" +
                "- Thêm các API và framework cho ứng dụng doanh nghiệp quy mô lớn\n" +
                "- Mục đích: Phát triển ứng dụng phân tán, đa tầng, ứng dụng web và dịch vụ\n" +
                "- Đối tượng: Lập trình viên phát triển ứng dụng doanh nghiệp, hệ thống lớn\n" +
                "- (Hiện tại được gọi là Jakarta EE sau khi chuyển từ Oracle sang Eclipse Foundation)\n" +
                "\n" +
                "**Java ME (Micro Edition):**\n" +
                "- Tối ưu hóa cho thiết bị nhỏ, giới hạn tài nguyên\n" +
                "- Cung cấp API nhẹ hơn cho môi trường giới hạn\n" +
                "- Mục đích: Phát triển ứng dụng cho thiết bị di động, IoT, thiết bị nhúng\n" +
                "- Đối tượng: Lập trình viên phát triển ứng dụng cho thiết bị có tài nguyên hạn chế\n" +
                "\n" +
                "Các phiên bản này được thiết kế để đáp ứng các nhu cầu khác nhau từ thiết bị nhỏ đến hệ thống doanh nghiệp lớn, cho phép Java trở thành một nền tảng linh hoạt và toàn diện.");
=======
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số tháng (1-12): ");
        int month = scanner.nextInt();

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("Tháng " + month + " có 31 ngày.");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("Tháng " + month + " có 30 ngày.");
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày.");
                break;
            default:
                System.out.println("Tháng không hợp lệ.");
                break;
        }

        scanner.close();
>>>>>>> 5830f00f22a74faa1f8a6324a3dc07ae54803b31
    }
}