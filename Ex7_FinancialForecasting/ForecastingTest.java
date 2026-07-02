package forecasting;

public class ForecastingTest {

    public static void main(String[] args) {

        double initialAmount = 100000.0;
        double annualGrowthRate = 0.08;
        int years = 5;

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Initial Investment : Rs. " + initialAmount);
        System.out.println("Annual Growth Rate : " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecast Period    : " + years + " years");

        System.out.println("\n--- Recursive Forecast (year by year) ---");
        for (int y = 1; y <= years; y++) {
            double value = FinancialForecast.predictFutureValue(initialAmount, annualGrowthRate, y);
            System.out.printf("Year %d : Rs. %.2f%n", y, value);
        }

        System.out.println("\n--- Optimized with Memoization ---");
        double[] memo = new double[years + 1];
        double finalValue = FinancialForecast.predictWithMemo(initialAmount, annualGrowthRate, years, memo);
        System.out.printf("Value after %d years : Rs. %.2f%n", years, finalValue);

        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Plain recursion     -> O(n) time, O(n) stack space");
        System.out.println("With memoization    -> O(n) time, avoids repeated calls");
        System.out.println("Iterative approach  -> O(n) time, O(1) space (most optimal)");
    }
}
