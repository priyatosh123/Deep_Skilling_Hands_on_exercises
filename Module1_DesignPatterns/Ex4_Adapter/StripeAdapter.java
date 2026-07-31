package adapter;


public class StripeAdapter implements PaymentProcessor {

    private final StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public boolean processPayment(double amount, String currency) {
        double amountInCents = amount * 100;
        return stripe.charge(amountInCents, currency);
    }
}
