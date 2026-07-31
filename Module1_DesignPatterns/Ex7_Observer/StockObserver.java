package observer;

/**
 * Anyone who wants live stock updates must implement this.
 */
public interface StockObserver {
    void update(String stockName, double newPrice);
}
