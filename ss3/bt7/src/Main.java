import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập 3 cạnh tam giác
        System.out.println("Nhập độ dài 3 cạnh của tam giác:");

        System.out.print("Cạnh 1: ");
        double side1 = scanner.nextDouble();

        System.out.print("Cạnh 2: ");
        double side2 = scanner.nextDouble();

        System.out.print("Cạnh 3: ");
        double side3 = scanner.nextDouble();

        // Kiểm tra tính hợp lệ của tam giác
        if (isValidTriangle(side1, side2, side3)) {
            // Phân loại tam giác
            String triangleType = classifyTriangle(side1, side2, side3);
            System.out.println("Đây là " + triangleType + ".");
        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        scanner.close();
    }

    // Kiểm tra 3 cạnh có tạo thành tam giác không
    public static boolean isValidTriangle(double a, double b, double c) {
        // Điều kiện tạo thành tam giác: tổng 2 cạnh bất kì phải lớn hơn cạnh còn lại
        // Và tất cả các cạnh phải dương
        return (a > 0 && b > 0 && c > 0) &&
                (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Phân loại tam giác
    public static String classifyTriangle(double a, double b, double c) {
        // Tam giác đều: 3 cạnh bằng nhau
        if (a == b && b == c) {
            return "tam giác đều";
        }
        // Tam giác cân: có 2 cạnh bằng nhau
        else if (a == b || b == c || a == c) {
            return "tam giác cân";
        }
        // Tam giác vuông: bình phương một cạnh bằng tổng bình phương hai cạnh còn lại
        else if (isRightTriangle(a, b, c)) {
            return "tam giác vuông";
        }
        // Trường hợp còn lại là tam giác thường
        else {
            return "tam giác thường";
        }
    }

    // Kiểm tra tam giác vuông bằng định lý Pythagoras
    public static boolean isRightTriangle(double a, double b, double c) {
        // Sắp xếp các cạnh theo thứ tự tăng dần
        double[] sides = {a, b, c};
        sort(sides);

        // Áp dụng định lý Pythagoras với sai số nhỏ do làm việc với số thực
        double epsilon = 0.0001;
        return Math.abs(sides[0] * sides[0] + sides[1] * sides[1] - sides[2] * sides[2]) < epsilon;
    }

    // Hàm sắp xếp mảng 3 phần tử theo thứ tự tăng dần
    public static void sort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}