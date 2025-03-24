package bt1;

public class Main {
    public static void main(String[] args) {
        // Định nghĩa nội dung của bảng
        String[] headers = {"Đặc điểm", "Class", "Object"};
        String[][] data = {
                {"Định nghĩa", "Là một khuôn mẫu, bản thiết kế hay nguyên mẫu để định nghĩa và mô tả các thuộc tính và hành vi chung của một nhóm đối tượng.", "Là một thực thể cụ thể được tạo ra từ class, có các thuộc tính và phương thức được xác định bởi class."},
                {"Vai trò", "Xác định cấu trúc dữ liệu và các phương thức mà các đối tượng của nó sẽ có. Đóng vai trò là bản thiết kế.", "Thể hiện cụ thể của class trong bộ nhớ, có thể tương tác với các đối tượng khác và thực hiện các hoạt động của chương trình."},
                {"Ví dụ thực tế", "Class Car định nghĩa các thuộc tính như màu sắc, hãng xe, năm sản xuất và các phương thức như khởi động, tăng tốc, phanh.", "Đối tượng myCar là một chiếc xe Toyota màu đỏ sản xuất năm 2020 cụ thể được tạo ra từ class Car."},
                {"Từ khóa liên quan", "class, extends, implements, abstract, interface, static, final...", "new, this, super, instanceof, null..."}
        };

        // Tìm độ rộng tối đa cho mỗi cột
        int[] columnWidths = findColumnWidths(headers, data);

        // In ra đường kẻ ngang đầu tiên
        printHorizontalLine(columnWidths);

        // In ra tiêu đề
        printRow(headers, columnWidths);

        // In ra đường kẻ ngang phía dưới tiêu đề
        printHorizontalLine(columnWidths);

        // In ra các dòng dữ liệu
        for (String[] row : data) {
            printRow(row, columnWidths);
        }

        // In ra đường kẻ ngang cuối cùng
        printHorizontalLine(columnWidths);
    }

    // Tìm độ rộng tối đa cho mỗi cột
    private static int[] findColumnWidths(String[] headers, String[][] data) {
        int[] columnWidths = new int[headers.length];

        // Kiểm tra độ rộng tiêu đề
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }

        // Kiểm tra độ rộng dữ liệu
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > columnWidths[i]) {
                    columnWidths[i] = row[i].length();
                }
            }
        }

        // Thêm khoảng trắng bên trái và phải cho mỗi ô
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] += 4; // Thêm 2 khoảng trắng bên trái và 2 khoảng trắng bên phải
        }

        return columnWidths;
    }

    // In ra đường kẻ ngang
    private static void printHorizontalLine(int[] columnWidths) {
        System.out.print("+");
        for (int width : columnWidths) {
            for (int i = 0; i < width; i++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    // In ra một dòng dữ liệu
    private static void printRow(String[] row, int[] columnWidths) {
        System.out.print("|");
        for (int i = 0; i < row.length; i++) {
            String cell = row[i];
            int padding = columnWidths[i] - cell.length();
            int leftPadding = padding / 2;
            int rightPadding = padding - leftPadding;

            for (int j = 0; j < leftPadding; j++) {
                System.out.print(" ");
            }

            System.out.print(cell);

            for (int j = 0; j < rightPadding; j++) {
                System.out.print(" ");
            }

            System.out.print("|");
        }
        System.out.println();
    }
}

