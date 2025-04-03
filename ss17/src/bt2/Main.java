package bt2;

import java.util.HashSet;
import java.util.Scanner;

//Viết chương trình kiểm tra xem một phần tử có tồn tại trong HashSet hay không
//
//Tạo một HashSet chứa các chuỗi: "Java", "Python", "C++", "JavaScript"
//Nhập một chuỗi từ bàn phím và kiểm tra xem chuỗi đó có tồn tại trong HashSet hay không
//In ra thông báo tương ứng
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("JavaScript");
        System.out.println("nhập chuỗi để kiểm tra: ");
        String input = sc.nextLine();
        if(set.contains(input)) {
            System.out.println("Chuỗi \"" + input + "\" tồn tại trong HashSet.");
        }else{
            System.out.println("Chuỗi \"" + input + "\"chưa tồn tại trong HashSet.");
        }
    }
}
