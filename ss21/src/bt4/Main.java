package bt4;

import java.util.InputMismatchException;
import java.util.Scanner;

//Viết chương trình cho phép người dùng nhập vào một số nguyên.
//
//Nếu người dùng nhập đúng kiểu số, in ra "Bạn đã nhập: <số>".
//
//Nếu nhập sai kiểu (ví dụ chữ cái), bắt lỗi và in ra "Lỗi: Bạn phải nhập số nguyên!".
//
//Dù có lỗi hay không, luôn in ra "Cảm ơn bạn đã sử dụng chương trình!" bằng cách sử dụng finally.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên: ");
            int soNguyen = scanner.nextInt();

            System.out.println("Bạn đã nhập: " + soNguyen);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");

        } finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
            scanner.close();
        }
    }
}