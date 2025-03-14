import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x,y;
        System.out.println("nhap x: ");
        x=sc.nextInt();
        System.out.println("nhap y: ");
        y=sc.nextInt();
        System.out.println("ket qua so sanh giua x= "+x+" va y="+y+ "la");
        System.out.println("x==y" + (x==y) );
        System.out.println("x!=y" +(x!=y));
        System.out.println("x>y" +(x>y));
        System.out.println("x<y" +(x<y));
        System.out.println("x>=y" +(x>=y));
        System.out.println("x<=y" +(x<=y));
        sc.close();

    }
}