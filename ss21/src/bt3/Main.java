package bt3;

import java.util.Scanner;

//Viết một chương trình yêu cầu người dùng nhập vào độ tuổi.
//Chương trình sẽ gọi một hàm riêng tên là checkAge(int age) để kiểm tra tuổi:
//
//Nếu tuổi nhỏ hơn 18, hàm checkAge sẽ ném ngoại lệ trực tiếp trong thân hàm bằng câu lệnh throw new Exception("Bạn chưa đủ 18 tuổi!").
//Nếu tuổi từ 18 trở lên, in ra: "Chào mừng bạn!".
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tuổi của bạn: ");
            int tuoi = scanner.nextInt();

            checkAge(tuoi);

        } catch (Exception e) {
            System.out.println("LỖI: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Bạn chưa đủ 18 tuổi!");
        } else {
            System.out.println("Chào mừng bạn!");
        }
    }
}
