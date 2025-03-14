import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //tinh bieu thuc toan hoc
        //java.lang.math ho tro phuong thuc va cac hang so lam viec voi bieu thuc
        //tinh dien tich va chu vi cac hinh: tron, thoi, tam giac, chu nhat dua tren cac canh
        Scanner sc = new Scanner(System.in);
        //hinh tron
        System.out.println("Hinh tron");
        System.out.println("nhap ban kinh r: ");
        float r=sc.nextFloat();
        float circleArea = (float) (Math.PI * r * r);
        float circlePerimeter = (float) (2 * Math.PI * r);
        System.out.println("Dien tich hinh tron: " + circleArea);
        System.out.println("Chu vi hinh tron: " + circlePerimeter);

        // Hinh thoi
        System.out.println("\nHinh thoi:");
        System.out.print("Nhap chieu dai canh a: ");
        float canhThoi = sc.nextFloat();
        System.out.print("Nhap chieu dai duong cheo d1: ");
        float cheo1 = sc.nextFloat();//cheo1
        System.out.print("Nhap chieu dai duong cheo d2: ");
        float cheo2 = sc.nextFloat();//cheo2
        float dtThoi = (cheo1 * cheo2) / 2;
        float cvThoi = 4 * canhThoi;
        System.out.println("Dien tich hinh thoi: " + dtThoi);
        System.out.println("Chu vi hinh thoi: " + cvThoi);

        // Hinh tam giac
        System.out.println("\nHinh tam giac (Triangle):");
        System.out.print("Nhap canh a: ");
        float sideA = sc.nextFloat();
        System.out.print("Nhap canh b: ");
        float sideB = sc.nextFloat();
        System.out.print("Nhap canh c: ");
        float sideC = sc.nextFloat();
        // Using Heron's formula to calculate area
        float s = (sideA + sideB + sideC) / 2;
        float triangleArea = (float) Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        float trianglePerimeter = sideA + sideB + sideC;
        System.out.println("Dien tich hinh tam giac: " + triangleArea);
        System.out.println("Chu vi hinh tam giac: " + trianglePerimeter);

        // Hinh chu nhat
        System.out.println("\nHinh chu nhat (Rectangle):");
        System.out.print("Nhap chieu dai: ");
        float cd = sc.nextFloat();
        System.out.print("Nhap chieu rong: ");
        float cr = sc.nextFloat();
        float rectangleArea = cd * cr;
        float rectanglePerimeter = 2 * (cd + cr);
        System.out.println("Dien tich hinh chu nhat: " + rectangleArea);
        System.out.println("Chu vi hinh chu nhat: " + rectanglePerimeter);

        sc.close();
    }
}