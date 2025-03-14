<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        System.out.println( "Bang cuu chuong 4");
        System.out.println("4x1=4");
        System.out.println("4x2=8");
        System.out.println("4x3=12");
        System.out.println("4x4=16");
        System.out.println("4x5=20");
        System.out.println("4x6=24");
        System.out.println("4x7=28");
        System.out.println("4x8=32");
        System.out.println("4x9=36");
        System.out.println("4x10=40");
=======
import java.util.Scanner;

//Nhập điểm trung bình của một sinh viên từ bàn phím (dạng số thực).
//Sử dụng câu lệnh if-else để xếp loại học lực của sinh viên theo thang điểm sau:
//Giỏi: Điểm từ 8.5 trở lên.
//Khá: Điểm từ 6.5 đến dưới 8.5.
//Trung bình: Điểm từ 5 đến dưới 6.5.
//Yếu: Điểm dưới 5.
//Hiển thị xếp loại học lực ra màn hình.
public class Main {
    public static void main(String[] args) {
        double diem;
        System.out.print("nhap diem: ");
        Scanner sc = new Scanner(System.in);
        diem = sc.nextDouble();
        sc.close();
        if (diem >= 11.0 && diem<0) {
            System.out.println("diem khong hop le");
        }
        else if (diem >=8.5) {
            System.out.println("xep loai gioi");
        }else if (diem >= 6.5 && diem < 8.5) {
            System.out.println("xep loai kha");
        }else if (diem >= 5 && diem < 6.5) {
            System.out.println("xep loai trung binh");
        }else if(diem < 5) {
            System.out.println("xep loai yeu");
        }
>>>>>>> 5830f00f22a74faa1f8a6324a3dc07ae54803b31
    }
}