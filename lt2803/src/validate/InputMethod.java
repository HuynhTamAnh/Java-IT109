package validate;

import java.util.Scanner;

public class InputMethod {
    public static final String ERROR_EMPTY_STRING = "Chuỗi không được để trống";
    public static final String ERROR_INTEGER = "Dữ liệu không phải số nguyên, vui lòng nhập lại";

    public static String inputString(Scanner sc, String title, String error) {
        System.out.println(title);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println(error);
            } else {
                return input;
            }
        }
    }

    public static boolean inputBoolean(Scanner scanner, String title, String error) {
        System.out.println(title);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("true") || input.equals("false")) {
                return input.equals("true");
            }
            System.err.println(error);
        }
    }

    public static int inputInteger(Scanner sc) {
        while (true) {
            try {
                System.out.print("Nhập mã sản phẩm: ");
                String input = sc.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println(ERROR_INTEGER);
            }
        }
    }

    public static float inputFloat(Scanner sc, String title) {
        while (true) {
            try {
                System.out.print(title);
                String input = sc.nextLine().trim();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu không phải số, vui lòng nhập lại");
            }
        }
    }
}