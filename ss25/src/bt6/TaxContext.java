package bt6;

public class TaxContext {
    private TaxCalculator taxCalculator;

    public TaxContext(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void setTaxCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public double calculateTax(double amount) {
        return taxCalculator.calculateTax(amount);
    }
}