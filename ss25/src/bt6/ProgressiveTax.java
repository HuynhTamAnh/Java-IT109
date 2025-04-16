package bt6;

public class ProgressiveTax implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        if (amount < 1000) {
            return amount * 0.05;
        } else {
            return amount * 0.10;
        }
    }
}