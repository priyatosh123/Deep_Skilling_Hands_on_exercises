package adapter;


public class StripeGateway {

    public boolean charge(double amountInCents, String currencyCode) {
        System.out.printf("Stripe: charging %.0f cents in %s%n",
                amountInCents, currencyCode);
        return true;
    }
}
