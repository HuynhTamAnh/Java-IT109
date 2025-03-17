import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào các hệ số
        System.out.println("Chương trình giải phương trình bậc hai ax² + bx + c = 0");

        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();

        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();

        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();

        // Xử lý các trường hợp
        if (a == 0) {
            // Trường hợp a = 0, phương trình trở thành bx + c = 0
            if (b == 0) {
                // Trường hợp b = 0, phương trình trở thành c = 0
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm");
                } else {
                    System.out.println("Phương trình vô nghiệm");
                }
            } else {
                // Trường hợp b ≠ 0, phương trình bậc nhất
                double x = -c / b;
                System.out.println("x = " + x + " (phương trình bậc nhất)");
            }
        } else {
            // Trường hợp a ≠ 0, phương trình bậc hai
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                // Phương trình có 2 nghiệm phân biệt
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2 + " (2 nghiệm phân biệt)");
            } else if (delta == 0) {
                // Phương trình có nghiệm kép
                double x = -b / (2 * a);
                System.out.println("x = " + x + " (nghiệm kép)");
            } else {
                // Phương trình vô nghiệm thực
                System.out.println("Phương trình vô nghiệm");
            }
        }

        scanner.close();
    }
}