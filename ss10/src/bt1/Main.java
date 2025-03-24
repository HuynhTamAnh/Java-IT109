package bt1;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. tính đóng gói là: Tính đóng gói là một trong bốn nguyên tắc cơ bản của lập trình hướng đối tượng (OOP). Đây là kỹ thuật đóng gói dữ liệu (thuộc tính) và các phương thức xử lý dữ liệu đó vào trong một đơn vị duy nhất (lớp), đồng thời hạn chế quyền truy cập trực tiếp đến dữ liệu từ bên ngoài.\n");
        System.out.println("Tính đóng gói quan trọng vì những lý do sau:\n" +
                "\n" +
                "Bảo vệ dữ liệu: Ngăn chặn việc truy cập và sửa đổi trực tiếp dữ liệu từ bên ngoài.\n" +
                "Linh hoạt trong phát triển: Cho phép thay đổi triển khai bên trong mà không ảnh hưởng đến code bên ngoài.\n" +
                "Kiểm soát dữ liệu: Kiểm tra tính hợp lệ của dữ liệu trước khi lưu trữ.\n" +
                "Che giấu thông tin: Chỉ hiển thị những gì cần thiết, giúp giảm sự phức tạp.");
        System.out.println("2.áp dụng: ");
        System.out.println("Trong Java, tính đóng gói được thực hiện thông qua:\n" +
                "\n" +
                "Access modifiers (Bộ điều chỉnh truy cập):\n" +
                "\n" +
                "private: Chỉ truy cập được trong cùng lớp\n" +
                "protected: Truy cập được trong cùng lớp, lớp con, và cùng package\n" +
                "public: Truy cập được từ bất kỳ đâu\n" +
                "Default (không ghi gì): Truy cập được trong cùng package\n" +
                "\n" +
                "\n" +
                "Getter và Setter:\n" +
                "\n" +
                "Getter: Phương thức public để lấy giá trị của thuộc tính private\n" +
                "Setter: Phương thức public để gán giá trị cho thuộc tính private, có thể kiểm tra tính hợp lệ của dữ liệu");
        System.out.println("cách sử dụng setter và getter: ");
        System.out.println("public class Person {\n" +
                "    private String name; // Thuộc tính private\n" +
                "    \n" +
                "    // Getter\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "    \n" +
                "    // Setter\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "}");
        System.out.println("------------------------------------");
        System.out.println("ví dụ về đóng gói");
        System.out.println("public class Person {\n" +
                "    // Thuộc tính private\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "    \n" +
                "    // Constructor\n" +
                "    public Person(String name, int age) {\n" +
                "        this.name = name;\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "    \n" +
                "    // Getter cho name\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "    \n" +
                "    // Setter cho name\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "    \n" +
                "    // Getter cho age\n" +
                "    public int getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "    \n" +
                "    // Setter cho age với kiểm tra tính hợp lệ\n" +
                "    public void setAge(int age) {\n" +
                "        if (age >= 0 && age <= 120) { // Kiểm tra tuổi hợp lệ\n" +
                "            this.age = age;\n" +
                "        } else {\n" +
                "            System.out.println(\"Tuổi không hợp lệ!\");\n" +
                "        }\n" +
                "    }\n" +
                "}");
        System.out.println("cách sử dụng class person: ");
        System.out.println("public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Person person = new Person(\"Nguyễn Văn A\", 25);\n" +
                "        \n" +
                "        // Lấy thông tin thông qua getter\n" +
                "        System.out.println(\"Tên: \" + person.getName());\n" +
                "        System.out.println(\"Tuổi: \" + person.getAge());\n" +
                "        \n" +
                "        // Cập nhật thông tin thông qua setter\n" +
                "        person.setName(\"Nguyễn Văn B\");\n" +
                "        person.setAge(30);\n" +
                "        \n" +
                "        // Kiểm tra thông tin sau khi cập nhật\n" +
                "        System.out.println(\"Tên mới: \" + person.getName());\n" +
                "        System.out.println(\"Tuổi mới: \" + person.getAge());\n" +
                "        \n" +
                "        // Kiểm tra tính hợp lệ\n" +
                "        person.setAge(150); // Sẽ hiển thị \"Tuổi không hợp lệ!\"\n" +
                "        System.out.println(\"Tuổi vẫn giữ nguyên: \" + person.getAge()); // Vẫn là 30\n" +
                "    }\n" +
                "}");
        System.out.println("4. lọi ích");
        System.out.println("Bảo vệ dữ liệu khỏi truy cập trái phép:\n" +
                "\n" +
                "Dữ liệu được khai báo private nên không thể truy cập trực tiếp từ bên ngoài lớp.\n" +
                "Mọi tương tác đều phải thông qua các phương thức được định nghĩa.\n" +
                "\n" +
                "\n" +
                "Kiểm soát cách thay đổi dữ liệu:\n" +
                "\n" +
                "Có thể thêm logic kiểm tra tính hợp lệ trong setter.\n" +
                "Ngăn chặn việc gán giá trị không hợp lệ cho các thuộc tính.\n" +
                "\n" +
                "\n" +
                "Che giấu chi tiết triển khai:\n" +
                "\n" +
                "Người dùng lớp chỉ biết cách sử dụng giao diện công khai (API) mà không cần biết chi tiết bên trong.\n" +
                "Có thể thay đổi cách triển khai bên trong mà không ảnh hưởng đến code đang sử dụng lớp.\n" +
                "\n" +
                "\n" +
                "Linh hoạt trong phát triển:\n" +
                "\n" +
                "Có thể thêm các bước xử lý bổ sung trong getter/setter mà không cần thay đổi code khác.\n" +
                "Ví dụ: Thêm ghi log, xác thực, hoặc chuyển đổi dữ liệu.\n" +
                "\n" +
                "\n" +
                "Giảm lỗi trong phát triển phần mềm:\n" +
                "\n" +
                "Giới hạn số lượng code có thể truy cập trực tiếp đến thuộc tính.\n" +
                "Tập trung việc kiểm tra tính hợp lệ tại một nơi.");
    }

}
