package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains price of a single stock and pushes updates to observers.
 */
public class StockMarket implements Stock {

    private final String stockName;
    private double price;
    private final List<StockObserver> observers = new ArrayList<>();

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver obs : observers) {
            obs.update(stockName, price);
        }
    }

    public void setPrice(double newPrice) {
        System.out.printf("%nStock [%s] price changed: %.2f -> %.2f%n",
                stockName, price, newPrice);
        this.price = newPrice;
        notifyObservers();
    }
}
