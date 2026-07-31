package observer;

public class WebApp implements StockObserver {

    @Override
    public void update(String stockName, double newPrice) {
        System.out.printf("  [Web Dashboard] Refreshing ticker: %s = ₹%.2f%n",
                stockName, newPrice);
    }
}
