package bt2;

public class Main {
    public static void main(String[] args) {
        System.out.println("# Tính Trừu Tượng trong Lập Trình Java\n" +
                "\n" +
                "## Định Nghĩa\n" +
                "\n" +
                "Tính trừu tượng là một khái niệm quan trọng trong lập trình hướng đối tượng (OOP), cho phép chúng ta che giấu những chi tiết phức tạp và chỉ hiển thị các chức năng cơ bản của đối tượng. Trong Java, tính trừu tượng được thể hiện thông qua các lớp trừu tượng (abstract class) và giao diện (interface).\n" +
                "\n" +
                "## Vai Trò của Tính Trừu Tượng\n" +
                "\n" +
                "Tính trừu tượng đóng vai trò quan trọng trong việc xây dựng phần mềm bằng cách:\n" +
                "- Giảm thiểu độ phức tạp của mã nguồn\n" +
                "- Tăng tính linh hoạt và khả năng mở rộng của chương trình\n" +
                "- Cho phép định nghĩa các hành vi chung mà các lớp con có thể kế thừa và triển khai\n" +
                "\n" +
                "## Ví Dụ Minh Hoạ\n" +
                "\n" +
                "Hãy xem xét ví dụ về các thiết bị điện tử như máy ATM, điều khiển TV, và ô tô:\n" +
                "\n" +
                "```java\n" +
                "// Lớp trừu tượng Thiết Bị\n" +
                "public abstract class ThietBi {\n" +
                "    protected String tenThietBi;\n" +
                "    \n" +
                "    // Phương thức trừu tượng bắt buộc các lớp con phải triển khai\n" +
                "    public abstract void batTat();\n" +
                "    \n" +
                "    // Phương thức cụ thể chung cho tất cả các thiết bị\n" +
                "    public void hienThiTrangThai() {\n" +
                "        System.out.println(\"Thiết bị: \" + tenThietBi);\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "// Lớp con cụ thể\n" +
                "public class MayATM extends ThietBi {\n" +
                "    @Override\n" +
                "    public void batTat() {\n" +
                "        System.out.println(\"Bật/Tắt máy ATM\");\n" +
                "    }\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "## Phân Tích Sâu Hơn\n" +
                "\n" +
                "### Tại Sao Cần Tính Trừu Tượng?\n" +
                "- Giúp quản lý mã nguồn phức tạp một cách dễ dàng\n" +
                "- Tạo ra một giao diện thống nhất cho các đối tượng\n" +
                "- Hỗ trợ tính kế thừa và đa hình\n" +
                "\n" +
                "### Sự Khác Biệt Giữa Lớp Trừu Tượng và Giao Diện\n" +
                "- Lớp trừu tượng có thể chứa phương thức đã được triển khai\n" +
                "- Giao diện chỉ chứa khai báo phương thức (trước Java 8)\n" +
                "- Một lớp chỉ được kế thừa từ một lớp trừu tượng, nhưng có thể triển khai nhiều giao diện\n" +
                "\n" +
                "## Kết Luận\n" +
                "\n" +
                "Tính trừu tượng là một công cụ mạnh mẽ trong lập trình Java, giúp các nhà phát triển tạo ra mã nguồn linh hoạt, dễ bảo trì và mở rộng.");
    }
}
