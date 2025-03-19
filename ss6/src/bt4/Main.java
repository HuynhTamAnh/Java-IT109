package bt4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Viết chương trình nhập vào một chuỗi văn bản và một từ cần tìm trong chuỗi đó.
//Chương trình sẽ kiểm tra xem từ cần tìm có xuất hiện trong chuỗi hay không, nếu có, chương trình sẽ in ra vị trí đầu tiên của từ trong chuỗi.
//Nếu từ không xuất hiện trong chuỗi, chương trình sẽ thông báo cho người dùng.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi văn bản:");
        String input = scanner.nextLine();

        //thay the tat ca cac ki tu (0-9) bang dau *
        String res=input.replaceAll("[0-9]", "*");
        System.out.println(res);
        scanner.close();
    }
}
