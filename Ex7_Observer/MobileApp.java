package observer;

public class MobileApp implements StockObserver {

    private final String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.printf("  [Mobile App - %s] Alert: %s is now ₹%.2f%n",
                userName, stockName, newPrice);
    }
}
