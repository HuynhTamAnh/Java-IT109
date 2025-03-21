package bt5;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] arr = null;
    private static int n = 0;

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputArray();
                    break;
                case 2:
                    printArray();
                    break;
                case 3:
                    calcPositiveAverage();
                    break;
                case 4:
                    viTri();
                    break;
                case 5:
                    demSoNguyenTo();
                    break;
                case 6:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

            System.out.println();
        } while (choice != 6);

        scanner.close();
    }

    // Hiển thị menu
    private static void showMenu() {
        System.out.println("************************ MENU ************************");
        System.out.println("1. Nhập giá trị n phần tử của mảng");
        System.out.println("2. In các phần tử trong mảng");
        System.out.println("3. Tính trung bình các phần tử dương");
        System.out.println("4. Tìm vị trí phần tử bằng k trong mảng");
        System.out.println("5. Đếm số lượng số nguyên tố trong mảng");
        System.out.println("6. Thoát chương trình");
        System.out.println("*****************************************************");
    }

    // Chức năng 1: Nhập mảng
    private static void inputArray() {
        System.out.print("Nhập số lượng phần tử n: ");
        n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }

        arr = new int[n];
        System.out.println("Nhập các phần tử:");

        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Đã nhập mảng thành công!");
    }

    // Chức năng 2: In mảng
    private static void printArray() {
        if (!isInit()) return;

        System.out.println("Các phần tử trong mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Chức năng 3: Trung bình số dương
    private static void calcPositiveAverage() {
        if (!isInit()) return;

        int sum = 0, count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Trung bình các phần tử dương: " + (double) sum / count);
        } else {
            System.out.println("Không có phần tử dương nào.");
        }
    }

    // Chức năng 4: Tìm vị trí phần tử = k
    private static void viTri() {
        if (!isInit()) return;

        System.out.print("Nhập giá trị k: ");
        int k = scanner.nextInt();
        boolean found = false;

        System.out.print("Vị trí của phần tử có giá trị " + k + ": ");
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy giá trị " + k + " trong mảng.");
        } else {
            System.out.println();
        }
    }

    // Chức năng 5: Đếm số nguyên tố
    private static void demSoNguyenTo() {
        if (!isInit()) return;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) {
                count++;
            }
        }

        System.out.println("Số lượng số nguyên tố trong mảng: " + count);
    }

    // Kiểm tra mảng đã khởi tạo chưa
    private static boolean isInit() {
        if (arr == null) {
            System.out.println("Vui lòng nhập mảng trước (chọn 1).");
            return false;
        }
        return true;
    }

    // Kiểm tra số nguyên tố
    private static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2 || x == 3) return true;
        if (x % 2 == 0 || x % 3 == 0) return false;

        for (int i = 5; i * i <= x; i += 6) {
            if (x % i == 0 || x % (i + 2) == 0) return false;
        }
        return true;
    }
}
