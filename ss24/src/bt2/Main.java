package bt2;
//Xây dựng một hệ thống tính thuế. Hệ thống có thể thêm các loại thuế mới mà không cần thay đổi mã nguồn hiện tại.
//
//Yêu cầu:
//
//Tạo interface TaxCalculator
//Có phương thức calculateTax(double amount)
//Triển khai các lớp IncomeTax (Thuế 10%), EnvironmentalTax (Thuế 5%)
//Sử dụng danh sách các đối tượng để tính tổng thuế của cả IncomeTax và EnviromentalTax
//Viết lớp Main kiểm thử các chức năng đã làm

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Create tax calculators
        TaxCalculator incomeTax = new IncomeTax();
        TaxCalculator environmentalTax = new EnvironmentalTax();

        // Create list of taxes
        List<TaxCalculator> taxCalculators = new ArrayList<>();
        taxCalculators.add(incomeTax);
        taxCalculators.add(environmentalTax);

        // Amount to calculate taxes for
        double amount = 1000000; // 1,000,000 VND

        // Calculate and display individual taxes
        System.out.println("Individual Taxes:");
        for (TaxCalculator calculator : taxCalculators) {
            String taxName = calculator.getClass().getSimpleName();
            double tax = calculator.calculateTax(amount);
            System.out.printf("%s: %.2f%n", taxName, tax);
        }

        // Calculate total tax
        double totalTax = calculateTotalTax(taxCalculators, amount);
        System.out.printf("%nTotal Tax: %.2f%n", totalTax);
    }

    public static double calculateTotalTax(List<TaxCalculator> calculators, double amount) {
        double total = 0;
        for (TaxCalculator calculator : calculators) {
            total += calculator.calculateTax(amount);
        }
        return total;
    }
}
