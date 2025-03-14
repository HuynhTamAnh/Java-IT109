import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        float mon1, mon2, mon3;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten hoc sinh: ");
        name = sc.nextLine();
        System.out.println("nhap so mon 1: ");
        mon1 = sc.nextFloat();
        System.out.println("nhap so mon 2: ");
        mon2 = sc.nextFloat();
        System.out.println("nhap so mon 3: ");
        mon3 = sc.nextFloat();
        float trungBinh= (mon1+mon2+mon3)/3;
        System.out.println("--------Hien thi thong tin hoc sinh-------");
        System.out.println("ten hoc sinh: "+name);
        System.out.println("Mon so 1: "+ mon1 + "| Mon so 2: "+mon2 +"| Mon so 3: "+mon3);
        System.out.println("Trung binh: "+trungBinh);
        //Xếp loại học sinh:
        //Dựa trên điểm trung bình, sử dụng toán tử 3 ngôi để đánh giá sinh viên có phải học lại hay sẽ được lên lớp


        String xepLoaiChiTiet;
        if (trungBinh >= 5.0) {
            xepLoaiChiTiet = "Len lop!";
        } else
            {
            xepLoaiChiTiet = "Khong len lop!";
            }

        System.out.println("Xep loai chi tiet: " + xepLoaiChiTiet);

        sc.close();
    }
}