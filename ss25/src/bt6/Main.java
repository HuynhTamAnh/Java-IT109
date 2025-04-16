package bt6;
//Xây dựng hệ thống tính thuế sử dụng Strategy Pattern, cho phép thay đổi cách tính thuế linh hoạt tùy từng loại chính sách.
//
//
//
//Yêu cầu:
//
//Tạo interface TaxCalculator
//Với phương thức calculateTax(double amount)
//Tạo các chiến lược tính thuế khác nhau như
//FlatRateTax – Tính thuế cố định 5%
//ProgressiveTax – Tính thuế lũy tiến:
//5% nếu < 1000
//10% nếu từ 1000 trở lên
//NoTax – Không tính thuế (0%)
//Tạo lớp TaxContext để áp dụng chiến lược tính thuế phù hợp dựa trên loại hình thuế được chọn
public class Main {
    public static void main(String[] args) {
        // Tạo các chiến lược tính thuế
        TaxCalculator flatRate = new FlatRateTax();
        TaxCalculator progressive = new ProgressiveTax();
        TaxCalculator noTax = new NoTax();

        // Tạo context với chiến lược mặc định
        TaxContext taxContext = new TaxContext(flatRate);

        // Tính thuế với các chiến lược khác nhau
        double amount = 1500;

        System.out.println("Thuế cố định (5%) cho " + amount + ": " + taxContext.calculateTax(amount));

        taxContext.setTaxCalculator(progressive);
        System.out.println("Thuế lũy tiến cho " + amount + ": " + taxContext.calculateTax(amount));

        taxContext.setTaxCalculator(noTax);
        System.out.println("Không tính thuế cho " + amount + ": " + taxContext.calculateTax(amount));

        // Kiểm tra với số tiền nhỏ hơn 1000
        amount = 800;
        taxContext.setTaxCalculator(progressive);
        System.out.println("\nThuế lũy tiến cho " + amount + ": " + taxContext.calculateTax(amount));
    }
}
