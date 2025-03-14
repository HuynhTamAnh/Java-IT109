import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khai báo các biến boolean a, b và c
        boolean a, b, c;

        // Nhập giá trị cho các biến
        System.out.print("Nhập giá trị cho a (true/false): ");
        a = scanner.nextBoolean();

        System.out.print("Nhập giá trị cho b (true/false): ");
        b = scanner.nextBoolean();

        System.out.print("Nhập giá trị cho c (true/false): ");
        c = scanner.nextBoolean();

        System.out.println("\nGiá trị đã nhập:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println();

        // Khai báo các biến điều kiện
        boolean condition1 = a && b;    // AND
        boolean condition2 = a || b;    // OR
        boolean condition3 = !c;        // NOT

        // Kiểm tra các điều kiện
        // Kiểm tra điều kiện AND
        if (a && b) {
            System.out.println("Cả hai đều đúng");
        }

        // Kiểm tra điều kiện OR
        if (a || b) {
            System.out.println("Ít nhất một đúng");
        }

        // Kiểm tra trường hợp a sai và b đúng
        if (!a && b) {
            System.out.println("Không đúng");
        }

        // Kiểm tra giá trị của c và đảo ngược giá trị của c
        System.out.println("Giá trị của c: " + c);
        System.out.println("Giá trị đảo ngược của c: " + !c);

        // In kết quả sử dụng toán tử 3 ngôi
        System.out.println("\nKết quả sử dụng toán tử 3 ngôi:");

        // Điều kiện 1: a && b
        String result1 = condition1 ? "Cả hai giá trị a và b đều đúng" : "Hoặc a sai hoặc b sai";
        System.out.println(result1);

        // Điều kiện 2: a || b
        String result2 = condition2 ? "Trong a và b có ít nhất 1 giá trị đúng" : "Cả 2 giá trị a và b đều sai";
        System.out.println(result2);

        // Điều kiện 3: !c
        String result3 = condition3 ? "Phủ định của c là đúng" : "Phủ định của c là sai";
        System.out.println(result3);

        scanner.close();
    }
}