package bt2;

public class EnvironmentalTax implements TaxCalculator {
    private static final double TAX_RATE = 0.05; // 5%

    @Override
    public double calculateTax(double amount) {
        return amount * TAX_RATE;
    }
}