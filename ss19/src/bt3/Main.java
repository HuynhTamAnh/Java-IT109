package bt3;

import java.util.Scanner;
import java.util.function.BiFunction;

//Viết chương trình Java thực hiện các yêu cầu sau:
//
//Nhập 2 số nguyên từ bàn phím(a, b).
//Tạo một lớp MathOperations với các phương thức tĩnh(static method):
//add(int a, int b) để thực hiện phép cộng.
//subtract(int a, int b) để thực hiện phép trừ.
//multiply(int a, int b) để thực hiện phép nhân.
//divide(int a, int b) để thực hiện phép chia.
//Sử dụng Method Reference (cú pháp ::) để gọi các phương thức này và thực hiện các phép toán trên hai số đã nhập từ bàn phím.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên thứ nhất (a): ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên thứ hai (b): ");
        int b = scanner.nextInt();
        scanner.close();

        // Phép cộng
        BiFunction<Integer, Integer, Integer> addition = MathOperations::add;
        System.out.println(a + " + " + b + " = " + addition.apply(a, b));

        // Phép trừ
        BiFunction<Integer, Integer, Integer> subtraction = MathOperations::subtract;
        System.out.println(a + " - " + b + " = " + subtraction.apply(a, b));

        // Phép nhân
        BiFunction<Integer, Integer, Integer> multiplication = MathOperations::multiply;
        System.out.println(a + " * " + b + " = " + multiplication.apply(a, b));

        // Phép chia
        BiFunction<Integer, Integer, Double> division = MathOperations::divide;
        System.out.println(a + " / " + b + " = " + division.apply(a, b));
    }
}

class MathOperations {
    // cộng
    public static int add(int a, int b) {
        return a + b;
    }

    // trừ
    public static int subtract(int a, int b) {
        return a - b;
    }

    // nhân
    public static int multiply(int a, int b) {
        return a * b;
    }

    // chia
    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Lỗi: Không thể chia cho 0!");
            return Double.NaN; // Not a Number
        }
        return (double) a / b;
    }
}