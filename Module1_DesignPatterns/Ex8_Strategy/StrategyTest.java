package strategy;

public class StrategyTest {

    public static void main(String[] args) {
        PaymentContext cart = new PaymentContext(
                new CreditCardPayment("4111111111111234", "Priyatosh Kumar")
        );

        System.out.println("--- Checkout with Credit Card ---");
        cart.executePayment(1499.00);

        System.out.println("\n--- Switching to PayPal ---");
        cart.setStrategy(new PayPalPayment("priyatosh@gmail.com"));
        cart.executePayment(2999.50);
    }
}
