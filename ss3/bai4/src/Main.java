import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.print("nhap number: ");
        switch (number = sc.nextInt()) {
            case 1:
                System.out.println("chu nhat");
                break;
            case 2:
                System.out.println("thu 2");
                break;
            case 3:
                System.out.println("thu 3");
                break;
            case 4:
                System.out.println("thu 4");
                break;
            case 5:
                System.out.println("thu 5");
                break;
            case 6:
                System.out.println("thu 6");
                break;
            case 7:
                System.out.println("thu 7");
            default:
                System.out.println("so nhap vao khong hop le");
                break;
        }
        sc.close();
    }
}