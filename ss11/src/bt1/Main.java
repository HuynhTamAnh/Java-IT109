package bt1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tình trừu tượng là quá trình che giấu các chi tiết phức tạp của một đối tượng và chỉ hiển thị các chức năng cần thiết cho người dùng. Trong lập trình Java, việc này được thực hiện thông qua:\n" +
                "\n" +
                "Lớp trừu tượng (Abstract Class)\n" +
                "Giao diện (Interface)");
        System.out.println("Ví Dụ Thực Tế về Tình Trừu Tượng\n");
        System.out.println("// Lớp trừu tượng Vehicle\n" +
                "public abstract class Vehicle {\n" +
                "    // Phương thức trừu tượng\n" +
                "    public abstract void start();\n" +
                "    public abstract void stop();\n" +
                "\n" +
                "    // Phương thức cụ thể\n" +
                "    public void refuel() {\n" +
                "        System.out.println(\"Đang nạp nhiên liệu\");\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "// Lớp con cụ thể\n" +
                "public class Car extends Vehicle {\n" +
                "    @Override\n" +
                "    public void start() {\n" +
                "        System.out.println(\"Xe khởi động bằng chìa khóa\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void stop() {\n" +
                "        System.out.println(\"Xe dừng lại\");\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "public class Motorcycle extends Vehicle {\n" +
                "    @Override\n" +
                "    public void start() {\n" +
                "        System.out.println(\"Xe máy khởi động bằng đạp chân\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void stop() {\n" +
                "        System.out.println(\"Xe máy phanh lại\");\n" +
                "    }\n" +
                "}");
        System.out.println("Vai Trò của Lớp Trừu Tượng\n" +
                "\n" +
                "Che giấu chi tiết phức tạp: Cung cấp giao diện đơn giản cho người dùng\n" +
                "Tái sử dụng mã nguồn: Cho phép các lớp con kế thừa và triển khai phương thức\n" +
                "Đảm bảo tính nhất quán: Các lớp con phải triển khai các phương thức trừu tượng\n" +
                "\n" +
                "Cách Sử Dụng\n" +
                "\n" +
                "Sử dụng từ khóa abstract để khai báo lớp trừu tượng\n" +
                "Không thể tạo đối tượng trực tiếp từ lớp trừu tượng\n" +
                "Các lớp con PHẢI triển khai tất cả các phương thức trừu tượng\n" +
                "\n" +
                "Lưu Ý Quan Trọng\n" +
                "\n" +
                "Lớp trừu tượng có thể chứa cả phương thức trừu tượng và phương thức cụ thể\n" +
                "Một lớp con chỉ được kế thừa từ một lớp trừu tượng duy nhất\n" +
                "Sử dụng khi muốn chia sẻ mã nguồn và tạo một giao diện chung\n" +
                "\n" +
                "Ưu Điểm\n" +
                "\n" +
                "Tăng tính trừu tượng\n" +
                "Hỗ trợ tính kế thừa\n" +
                "Cải thiện tính bảo trì của mã nguồn");
    }
}
