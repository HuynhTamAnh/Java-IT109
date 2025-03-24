package bt2;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?\n" +
                "Kế thừa là một nguyên tắc cơ bản trong lập trình hướng đối tượng, cho phép một lớp (lớp con) kế thừa các thuộc tính và phương thức từ một lớp khác (lớp cha). Lớp con có thể sử dụng lại code từ lớp cha, đồng thời có thể mở rộng hoặc ghi đè các chức năng theo nhu cầu của riêng mình.\n" +
                "Kế thừa giúp ích trong lập trình hướng đối tượng như sau:\n" +
                "\n" +
                "Tái sử dụng code: Giảm việc viết lại các code đã có, giúp tiết kiệm thời gian và công sức.\n" +
                "Tổ chức cấu trúc phân cấp: Tạo mối quan hệ phân cấp giữa các lớp, phản ánh mối quan hệ \"is-a\" (là một).\n" +
                "Mở rộng chức năng: Cho phép mở rộng chức năng của lớp có sẵn mà không cần sửa đổi lớp đó.\n" +
                "Đa hình: Cho phép sử dụng các phương thức của lớp cha với các triển khai khác nhau ở lớp con.");
        System.out.println("2. Sự khác biệt giữa kế thừa và bao đóng (encapsulation) trong Java là gì?\n");
        System.out.println("Kế thừa (Inheritance)");
        System.out.println("Tập trung vào mối quan hệ \"is-a\" giữa các lớp");
        System.out.println("Cho phép tái sử dụng code từ lớp cha");
        System.out.println("Thực hiện thông qua từ khóa extends");
        System.out.println("Liên quan đến nhiều lớp có mối quan hệ với nhau");
        System.out.println("Mục đích: Tái sử dụng và mở rộng chức năng");
        System.out.println("Bao đóng (Encapsulation)");
        System.out.println("Tập trung vào việc ẩn chi tiết triển khai và bảo vệ dữ liệu");
        System.out.println("Giới hạn quyền truy cập trực tiếp đến dữ liệu");
        System.out.println("Thực hiện thông qua access modifiers (private, protected, public) và getter/setter");
        System.out.println("Liên quan đến việc tổ chức dữ liệu và phương thức trong một lớp duy nhất");
        System.out.println("Mục đích: Bảo vệ dữ liệu và kiểm soát quyền truy cập\n");
        System.out.println("3. Ví dụ sử dụng từ khóa extends để tạo lớp con kế thừa các thuộc tính và phương thức từ lớp cha\n");
        System.out.println("// Lớp cha (Parent class)\n" +
                "class Animal {\n" +
                "    protected String name;\n" +
                "    protected int age;\n" +
                "    \n" +
                "    // Constructor\n" +
                "    public Animal(String name, int age) {\n" +
                "        this.name = name;\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "    \n" +
                "    // Phương thức của lớp cha\n" +
                "    public void eat() {\n" +
                "        System.out.println(name + \" đang ăn.\");\n" +
                "    }\n" +
                "    \n" +
                "    public void sleep() {\n" +
                "        System.out.println(name + \" đang ngủ.\");\n" +
                "    }\n" +
                "    \n" +
                "    // Getter và Setter\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "    \n" +
                "    public int getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "// Lớp con kế thừa từ lớp Animal\n" +
                "class Dog extends Animal {\n" +
                "    private String breed; // Thuộc tính riêng của lớp Dog\n" +
                "    \n" +
                "    // Constructor của lớp con\n" +
                "    public Dog(String name, int age, String breed) {\n" +
                "        super(name, age); // Gọi constructor của lớp cha\n" +
                "        this.breed = breed;\n" +
                "    }\n" +
                "    \n" +
                "    // Phương thức riêng của lớp Dog\n" +
                "    public void bark() {\n" +
                "        System.out.println(name + \" đang sủa: Gâu gâu!\");\n" +
                "    }\n" +
                "    \n" +
                "    // Ghi đè (override) phương thức của lớp cha\n" +
                "    @Override\n" +
                "    public void eat() {\n" +
                "        System.out.println(name + \" (giống \" + breed + \") đang ăn xương.\");\n" +
                "    }\n" +
                "    \n" +
                "    // Getter cho thuộc tính riêng\n" +
                "    public String getBreed() {\n" +
                "        return breed;\n" +
                "    }\n" +
                "}");
        System.out.println("sử dụng: ");
        System.out.println("public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        // Tạo đối tượng từ lớp con\n" +
                "        Dog myDog = new Dog(\"Rex\", 3, \"Labrador\");\n" +
                "        \n" +
                "        // Sử dụng phương thức kế thừa từ lớp cha\n" +
                "        System.out.println(\"Tên: \" + myDog.getName());\n" +
                "        System.out.println(\"Tuổi: \" + myDog.getAge());\n" +
                "        myDog.sleep(); // Phương thức từ lớp cha\n" +
                "        \n" +
                "        // Sử dụng phương thức riêng của lớp con\n" +
                "        System.out.println(\"Giống: \" + myDog.getBreed());\n" +
                "        myDog.bark();\n" +
                "        \n" +
                "        // Sử dụng phương thức đã ghi đè\n" +
                "        myDog.eat(); // Gọi phiên bản đã ghi đè ở lớp con\n" +
                "    }\n" +
                "}");
        System.out.println("4. Lợi ích và hạn chế khi sử dụng kế thừa trong Java\n" +
                "Lợi ích:\n" +
                "\n" +
                "Tái sử dụng code: Giảm lặp lại code, tiết kiệm thời gian phát triển.\n" +
                "Cấu trúc phân cấp rõ ràng: Tạo mối quan hệ phân cấp logic giữa các đối tượng.\n" +
                "Bảo trì dễ dàng: Thay đổi ở lớp cha sẽ áp dụng cho tất cả lớp con.\n" +
                "Đa hình: Cho phép xử lý các đối tượng khác nhau theo cách thống nhất.\n" +
                "Mở rộng chức năng: Thêm chức năng mới vào lớp con mà không ảnh hưởng đến lớp cha.\n" +
                "\n" +
                "Hạn chế:\n" +
                "\n" +
                "Kết hợp chặt chẽ (Tight coupling): Lớp con phụ thuộc vào lớp cha, thay đổi lớp cha có thể ảnh hưởng đến lớp con.\n" +
                "Kế thừa đơn: Java chỉ hỗ trợ kế thừa đơn (một lớp chỉ có thể kế thừa từ một lớp cha), hạn chế khả năng mở rộng.\n" +
                "Phá vỡ tính đóng gói: Có thể làm giảm tính đóng gói nếu sử dụng không đúng cách.\n" +
                "Vấn đề \"Fragile base class\": Thay đổi lớp cha có thể gây ra lỗi không mong muốn trong lớp con.\n" +
                "Độ phức tạp tăng: Cấu trúc kế thừa phức tạp có thể khó hiểu và bảo trì.\n" +
                "Sử dụng quá mức: Lạm dụng kế thừa khi không cần thiết có thể dẫn đến thiết kế phức tạp không cần thiết.");
    }
}
