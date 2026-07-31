package strategy;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String holderName;

    public CreditCardPayment(String cardNumber, String holderName) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Credit Card [****%s] | Holder: %s | Amount: ₹%.2f%n",
                cardNumber.substring(cardNumber.length() - 4), holderName, amount);
        System.out.println("Payment authorized.");
        return true;
    }
}
