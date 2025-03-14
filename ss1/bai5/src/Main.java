import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so dau tien num1: ");
        double num1 = sc.nextInt();
        System.out.print("nhap so thu2 num2: ");
        double num2 = sc.nextInt();
        System.out.print("nhap phep tinh: ");
        String phepTinh = sc.next();
        double result = 0;
        boolean isPhepTinh = true;
        switch (phepTinh) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("khong co chia cho 0");
                    isPhepTinh = false;
                }else{
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("phep tinh khong hop le");
                isPhepTinh = false;
                break;
        }
        if( isPhepTinh && !(phepTinh.equals("/") && num2 == 0)) {
            System.out.println("Kết quả: " + result);
        }
        sc.close();


    }
}