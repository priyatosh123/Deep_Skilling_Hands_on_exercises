package adapter;


public class PayPalAdapter implements PaymentProcessor {

    private final PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public boolean processPayment(double amount, String currency) {
        String result = paypal.sendPayment(String.valueOf(amount), currency);
        return "SUCCESS".equals(result);
    }
}
