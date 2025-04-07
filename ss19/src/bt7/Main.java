package bt7;
//Viết chương trình Java thực hiện các chức năng sau:
//
//Tạo một interface tên là ListProcessor với:
//1 phương thức abstract: containsNegative(List<Integer> list) để kiểm tra xem danh sách có chứa số âm hay không.
//1 phương thức static: printList(List<Integer> list) để in danh sách số nguyên.
//Tạo lớp ListProcessorImpl:
//Lớp này sẽ implements interface ListProcessor và cài đặt phương thức abstract containsNegative(List<Integer> list).
//Kiểm tra xem có xuất hiện phần tử âm hay không
//Cần sử dụng Predicate để kiểm tra số âm
//Kiểm chứng
//Tiến hành kiểm chứng trên hàm main và quan sát kết quả
//Sử dụng phương thức static printList để in danh sách
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

interface ListProcessor {
    // Phương thức abstract để kiểm tra xem danh sách có chứa số âm hay không
    boolean containsNegative(List<Integer> list);

    // Phương thức static để in danh sách số nguyên
    static void printList(List<Integer> list) {
        System.out.println("Danh sách số nguyên:");
        for (Integer number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}


class ListProcessorImpl implements ListProcessor {
    @Override
    public boolean containsNegative(List<Integer> list) {
        // Sử dụng Predicate để kiểm tra số âm
        Predicate<Integer> isNegative = number -> number < 0;

        // Kiểm tra xem có phần tử nào trong danh sách thỏa mãn điều kiện là số âm không
        for (Integer number : list) {
            if (isNegative.test(number)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListProcessorImpl processor = new ListProcessorImpl();

        System.out.print("Nhập số lượng danh sách cần kiểm tra: ");
        int numLists = scanner.nextInt();

        for (int i = 0; i < numLists; i++) {
            System.out.print("Nhập số lượng phần tử trong danh sách " + (i + 1) + ": ");
            int size = scanner.nextInt();

            List<Integer> list = new ArrayList<>();
            System.out.println("Nhập " + size + " số nguyên:");
            for (int j = 0; j < size; j++) {
                System.out.print("Phần tử thứ " + (j + 1) + ": ");
                list.add(scanner.nextInt());
            }

            System.out.println("\nDanh sách " + (i + 1) + ":");
            ListProcessor.printList(list);

            if (processor.containsNegative(list)) {
                System.out.println("Danh sách chứa số âm");
            } else {
                System.out.println("Danh sách không chứa số âm");
            }
            System.out.println();
        }

        scanner.close();
    }
}