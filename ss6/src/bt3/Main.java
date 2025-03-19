package bt3;
//Viết chương trình nhập vào một chuỗi văn bản và một từ cần tìm trong chuỗi đó.
//Chương trình sẽ kiểm tra xem từ cần tìm có xuất hiện trong chuỗi hay không, nếu có, chương trình sẽ in ra vị trí đầu tiên của từ trong chuỗi.
//Nếu từ không xuất hiện trong chuỗi, chương trình sẽ thông báo cho người dùng.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi van ban: ");
        String input = sc.nextLine();
        System.out.print("Nhap tu can tim: ");
        String tim = sc.nextLine();
        int pos=input.indexOf(tim);
        if(pos!=-1) {
            System.out.print("Tu \""+tim+"\"xuat hien tai vi tri"+pos+"trong chuoi. ");
        }else {
            System.out.println("Không tìm thấy từ \"" + tim + "\" trong chuỗi.");
        }
        sc.close();

    }
}
