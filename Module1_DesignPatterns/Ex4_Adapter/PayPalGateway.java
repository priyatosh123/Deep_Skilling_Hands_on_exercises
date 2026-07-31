package adapter;


public class PayPalGateway {

    public String sendPayment(String amount, String currency) {
        System.out.printf("PayPal: sending payment of %s %s%n", amount, currency);
        return "SUCCESS";
    }
}
