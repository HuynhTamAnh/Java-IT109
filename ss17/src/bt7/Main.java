package bt7;

import java.util.*;

//Viết chương trình java thực hiện các yêu cầu sau:
//
//Nhập một đoạn văn bản từ bàn phím
//Tách các từ trong đoạn văn (không phân biệt chữ hoa, chữ thường)
//Sử dụng Set để lưu các từ không trùng lặp và đếm số lần mỗi từ xuất hiện
//In danh sách các từ và số lần xuất hiện của chúng theo thứ tự bảng chữ cái
//Sắp xếp kết quả theo thứ tự bảng chữ cái.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đoạn văn bản:");
        String text = scanner.nextLine().toLowerCase();

        // Tách từng chữ
        String[] words = text.split("\\W+");

        // lưu vào list(có trùng lặp)
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordList.add(word);
            }
        }

        // lưu kh trùng lặp
        Set<String> uniqueWords = new HashSet<>(wordList);

        // Sắp xếp kh trùng theo thứ tự
        List<String> sortedUniqueWords = new ArrayList<>(uniqueWords);
        Collections.sort(sortedUniqueWords);

        // Đếm và in
        System.out.println("\nDanh sách các từ và số lần xuất hiện:");
        for (String word : sortedUniqueWords) {
            int frequency = Collections.frequency(wordList, word);
            System.out.println(word + ": " + frequency);
        }

        scanner.close();
    }
}