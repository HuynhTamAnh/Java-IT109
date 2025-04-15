package bt6;

public class SalesRoleImpl implements SalesRole {
    @Override
    public void performResponsibilities() {
        System.out.println("Performing sales duties");
    }

    @Override
    public void makeSale() {
        System.out.println("Making a sale to customer");
    }

    @Override
    public void contactCustomer() {
        System.out.println("Contacting potential customer");
    }
}