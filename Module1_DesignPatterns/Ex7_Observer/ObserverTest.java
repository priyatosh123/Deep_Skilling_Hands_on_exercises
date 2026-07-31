package observer;

public class ObserverTest {

    public static void main(String[] args) {
        StockMarket tcs = new StockMarket("TCS", 3500.00);

        StockObserver mobileUser1 = new MobileApp("Priyatosh");
        StockObserver mobileUser2 = new MobileApp("Riya");
        StockObserver webDashboard = new WebApp();

        tcs.registerObserver(mobileUser1);
        tcs.registerObserver(mobileUser2);
        tcs.registerObserver(webDashboard);

        tcs.setPrice(3550.75);
        tcs.setPrice(3490.00);

        System.out.println("\nRiya unsubscribed from alerts.");
        tcs.removeObserver(mobileUser2);

        tcs.setPrice(3600.00);
    }
}
