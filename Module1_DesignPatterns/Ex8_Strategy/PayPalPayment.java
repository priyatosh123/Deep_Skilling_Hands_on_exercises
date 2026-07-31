package strategy;

public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("PayPal [%s] | Amount: ₹%.2f%n", email, amount);
        System.out.println("PayPal payment processed.");
        return true;
    }
}
