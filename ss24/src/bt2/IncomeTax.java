package bt2;

public class IncomeTax implements TaxCalculator {
    private static final double TAX_RATE = 0.10; // 10%

    @Override
    public double calculateTax(double amount) {
        return amount * TAX_RATE;
    }
}