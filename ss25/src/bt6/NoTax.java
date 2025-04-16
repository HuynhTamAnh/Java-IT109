package bt6;

public class NoTax implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return 0; // Không tính thuế
    }
}