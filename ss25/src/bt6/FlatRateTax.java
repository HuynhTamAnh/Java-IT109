package bt6;

public class FlatRateTax implements TaxCalculator {
    private static final double TAX_RATE = 0.05;

    @Override
    public double calculateTax(double amount) {
        return amount * TAX_RATE;
    }
}