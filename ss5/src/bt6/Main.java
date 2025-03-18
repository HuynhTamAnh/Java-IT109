package bt6;
//Khởi tạo mảng
//Khởi tạo mảng markingArray[1000]
//Khởi tạo mảng originalArray[20] và gán giá trị các phần tử trong mảng trong khoảng từ 1 đến 1000.
//Học viên khởi tạo trực tiếp 20 giá trị trong khoảng từ 1-1000 mà không cần nhập từ bàn phím
//Chương trình phải thực hiện:
//Duyệt qua phần tử của mảng originalArray và dùng phương pháp Marking Array để đếm và lưu số lần xuất hiện vào mảng markingArray
//Tìm phần tử hoặc các phần tử có số lần xuất hiện nhiều nhất.
//Xuất ra phần tử xuất hiện nhiều nhất cùng với số lần xuất hiện.
public class Main {
    public static void main(String[] args) {
        // Khởi tạo mảng markingArray[1000]
        int[] markingArray = new int[1001]; // Sử dụng 1001 phần tử để có thể đánh chỉ số từ 1-1000

        // Khởi tạo mảng originalArray[20] với các giá trị trong khoảng 1-1000
        int[] originalArray = {42, 7, 512, 17, 42, 100, 512, 17, 42, 1000,
                7, 42, 127, 512, 250, 42, 17, 100, 42, 250};

        // Sử dụng marking array để đếm số lần xuất hiện
        for (int i = 0; i < originalArray.length; i++) {
            markingArray[originalArray[i]]++;
        }

        // Tìm số lần xuất hiện lớn nhất
        int maxFrequency = 0;
        for (int i = 1; i <= 1000; i++) {
            if (markingArray[i] > maxFrequency) {
                maxFrequency = markingArray[i];
            }
        }

        // In ra các phần tử có số lần xuất hiện nhiều nhất
        System.out.println("Phan tu xuat hien nhieu nhat:");
        for (int i = 1; i <= 1000; i++) {
            if (markingArray[i] == maxFrequency) {
                System.out.println("Phan tu " + i + " xuat hien " + maxFrequency + " lan");
            }
        }
    }
}