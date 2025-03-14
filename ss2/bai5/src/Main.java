import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float cd,cr;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap cd: ");
        cd=sc.nextFloat();
        System.out.println("nhap cr: ");
        cr=sc.nextFloat();
        float aread=cd*cr;
        float circumference=2*cd+2*cr;
        System.out.println("dien tich="+aread);
        System.out.println("chu vi="+circumference);
        sc.close();
    }
}