import java.util.*;

class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    double balance;
    Map<String, Integer> holdings;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
        this.holdings = new HashMap<>();
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (balance >= cost) {
            balance -= cost;
            holdings.put(stock.symbol, holdings.getOrDefault(stock.symbol, 0) + quantity);
            System.out.println("Successfully bought " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int currentShares = holdings.getOrDefault(stock.symbol, 0);
        if (currentShares >= quantity) {
            balance += stock.price * quantity;
            holdings.put(stock.symbol, currentShares - quantity);
            System.out.println("Successfully sold " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public void displayPortfolio(Map<String, Stock> market) {
        System.out.println("\n--- Portfolio Performance ---");
        System.out.printf("Cash Balance: $%.2f\n", balance);
        double totalValue = balance;
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            if (entry.getValue() > 0) {
                double value = entry.getValue() * market.get(entry.getKey()).price;
                totalValue += value;
                System.out.printf("%s: %d shares (Value: $%.2f)\n", entry.getKey(), entry.getValue(), value);
            }
        }
        System.out.printf("Total Portfolio Value: $%.2f\n", totalValue);
    }
}

public class StockPlatform {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Stock> market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", 150.0));
        market.put("GOOGL", new Stock("GOOGL", 2800.0));
        market.put("TSLA", new Stock("TSLA", 700.0));

        Portfolio myPortfolio = new Portfolio(10000.0);

        while (true) {
            System.out.println("\n1. View Market Data | 2. Buy | 3. Sell | 4. View Portfolio | 5. Exit");
            System.out.print("Choose option: ");
            String choice = in.nextLine();

            if (choice.equals("5")) break;

            if (choice.equals("1")) {
                System.out.println("\n--- Market Data ---");
                for (Stock s : market.values()) System.out.printf("%s