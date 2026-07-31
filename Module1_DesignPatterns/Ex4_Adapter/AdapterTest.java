package adapter;


public class AdapterTest {

    static void checkout(PaymentProcessor processor, double amount) {
        boolean ok = processor.processPayment(amount, "USD");
        System.out.println("Payment " + (ok ? "successful" : "failed") + "\n");
    }

    public static void main(String[] args) {
        System.out.println("--- Paying via Stripe ---");
        checkout(new StripeAdapter(new StripeGateway()), 499.99);

        System.out.println("--- Paying via PayPal ---");
        checkout(new PayPalAdapter(new PayPalGateway()), 299.00);
    }
}
