package bt6;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String inputString = "";
    private static int[] numberArray = null;

    public static void main(String[] args) {
        int choice;

        do {
            // Hiển thị menu chính
            showMainMenu();
            choice = getMenuChoice(1, 3);

            switch (choice) {
                case 1:
                    //xu ly chuoi
                    processStringMenu();
                    break;
                case 2:
                    //xu ly so nguyen
                    processNumberMenu();
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc. Tạm biệt!");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    // Hiển thị menu chính
    private static void showMainMenu() {
        System.out.println("\n===== MENU CHÍNH =====");
        System.out.println("1. Xử lý chuỗi");
        System.out.println("2. Xử lý số nguyên");
        System.out.println("3. Thoát chương trình");
        System.out.print("Chọn chức năng (1-3): ");
    }

    // Xử lý menu chuỗi
    private static void processStringMenu() {
        int choice;

        do {
            showStringMenu();
            choice = getMenuChoice(1, 5);

            switch (choice) {
                case 1:
                    inputString();
                    break;
                case 2:
                    removeExtraSpaces();
                    break;
                case 3:
                    countCharacterOccurrences();
                    break;
                case 4:
                    convertToTitleCase();
                    break;
                case 5:
                    // Quay lại menu chính
                    break;
            }
        } while (choice != 5);
    }

    // Hiển thị menu xử lý chuỗi
    private static void showStringMenu() {
        System.out.println("\n===== MENU XỬ LÝ CHUỖI =====");
        System.out.println("1. Nhập chuỗi");
        System.out.println("2. Loại bỏ khoảng trắng thừa trong chuỗi");
        System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
        System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn (viết hoa chữ cái đầu mỗi từ)");
        System.out.println("5. Quay lại menu chính");
        System.out.print("Chọn chức năng (1-5): ");
    }

    // Xử lý menu số nguyên
    private static void processNumberMenu() {
        int choice;

        do {
            showNumberMenu();
            choice = getMenuChoice(1, 5);

            switch (choice) {
                case 1:
                    inputNumberArray();
                    break;
                case 2:
                    findLargestPrime();
                    break;
                case 3:
                    countOddDigitNumbers();
                    break;
                case 4:
                    checkSymmetricArray();
                    break;
                case 5:
                    // Quay lại menu chính
                    break;
            }
        } while (choice != 5);
    }

    // Hiển thị menu xử lý số nguyên
    private static void showNumberMenu() {
        System.out.println("\n===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====");
        System.out.println("1. Nhập mảng số nguyên");
        System.out.println("2. Tìm số nguyên tố lớn nhất trong mảng");
        System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
        System.out.println("4. Kiểm tra mảng có phải là mảng đối xứng không");
        System.out.println("5. Quay lại menu chính");
        System.out.print("Chọn chức năng (1-5): ");
    }

    // Lấy lựa chọn menu từ người dùng
    private static int getMenuChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Xử lý ký tự xuống dòng
                if (choice < min || choice > max) {
                    System.out.print("Lựa chọn không hợp lệ. Vui lòng chọn lại (" + min + "-" + max + "): ");
                }
            } catch (Exception e) {
                scanner.nextLine(); // Xử lý input không hợp lệ
                System.out.print("Lựa chọn phải là số. Vui lòng chọn lại (" + min + "-" + max + "): ");
            }
        }
        return choice;
    }

    // Các chức năng xử lý chuỗi
    private static void inputString() {
        System.out.print("Nhập chuỗi: ");
        inputString = scanner.nextLine();
        System.out.println("Đã nhập chuỗi: " + inputString);
    }
    //loai bo khoang trang
    private static void removeExtraSpaces() {
        if (inputString.isEmpty()) {
            System.out.println("Bạn chưa nhập chuỗi. Vui lòng nhập chuỗi trước.");
            return;
        }

        String result = inputString.trim().replaceAll("\\s+", " ");
        System.out.println("Chuỗi sau khi loại bỏ khoảng trắng thừa: " + result);
    }
    //dem so lan xuat hien tung ki tu
    private static void countCharacterOccurrences() {
        if (inputString.isEmpty()) {
            System.out.println("Bạn chưa nhập chuỗi. Vui lòng nhập chuỗi trước.");
            return;
        }

        System.out.println("Số lần xuất hiện của từng ký tự trong chuỗi:");

        // Tạo mảng đếm cho mỗi ký tự
        int[] count = new int[Character.MAX_VALUE + 1];
        for (char c : inputString.toCharArray()) {
            count[c]++;
        }

        // Hiển thị kết quả
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println("'" + (char)i + "': " + count[i] + " lần");
            }
        }
    }
    //chuyen doi chuoi thanh dang chuan (viet hoa chu cai dau)
    private static void convertToTitleCase() {
        if (inputString.isEmpty()) {
            System.out.println("Bạn chưa nhập chuỗi. Vui lòng nhập chuỗi trước.");
            return;
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : inputString.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                result.append(c);
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        System.out.println("Chuỗi sau khi chuyển đổi: " + result.toString());
    }

    // Các chức năng xử lý số nguyên
    private static void inputNumberArray() {
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Số lượng phần tử phải lớn hơn 0.");
            return;
        }

        numberArray = new int[size];
        System.out.println("Nhập " + size + " phần tử:");

        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            numberArray[i] = scanner.nextInt();
        }

        scanner.nextLine(); // Xử lý ký tự xuống dòng
        System.out.println("Đã nhập mảng: " + Arrays.toString(numberArray));
    }
    //tim so nguyen to lon nhat
    private static void findLargestPrime() {
        if (numberArray == null || numberArray.length == 0) {
            System.out.println("Mảng chưa được khởi tạo. Vui lòng nhập mảng trước.");
            return;
        }

        int largestPrime = -1;

        for (int num : numberArray) {
            if (isPrime(num) && num > largestPrime) {
                largestPrime = num;
            }
        }

        if (largestPrime == -1) {
            System.out.println("Không có số nguyên tố nào trong mảng.");
        } else {
            System.out.println("Số nguyên tố lớn nhất trong mảng là: " + largestPrime);
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        if (num <= 3) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    //dem so lan xuat hien cua chu so co so le dau tien
    private static void countOddDigitNumbers() {
        if (numberArray == null || numberArray.length == 0) {
            System.out.println("Mảng chưa được khởi tạo. Vui lòng nhập mảng trước.");
            return;
        }

        int count = 0;

        for (int num : numberArray) {
            // Lấy chữ số đầu tiên
            int firstDigit = Math.abs(num);
            while (firstDigit >= 10) {
                firstDigit /= 10;
            }

            // Kiểm tra nếu là số lẻ
            if (firstDigit % 2 != 0) {
                count++;
            }
        }

        System.out.println("Số phần tử có chữ số đầu tiên là số lẻ: " + count);

        // Hiển thị các phần tử
        System.out.print("Các phần tử đó là: ");
        for (int num : numberArray) {
            int firstDigit = Math.abs(num);
            while (firstDigit >= 10) {
                firstDigit /= 10;
            }

            if (firstDigit % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    //mang doi xung
    private static void checkSymmetricArray() {
        if (numberArray == null || numberArray.length == 0) {
            System.out.println("Mảng chưa được khởi tạo. Vui lòng nhập mảng trước.");
            return;
        }

        boolean isSymmetric = true;

        for (int i = 0; i < numberArray.length / 2; i++) {
            if (numberArray[i] != numberArray[numberArray.length - 1 - i]) {
                isSymmetric = false;
                break;
            }
        }

        if (isSymmetric) {
            System.out.println("Mảng là mảng đối xứng.");
        } else {
            System.out.println("Mảng không phải là mảng đối xứng.");
        }
    }
}
