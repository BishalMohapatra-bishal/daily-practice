package ScenarioBasedQuestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StockTracker {
    private final Map<String, Integer> stocks;

    public StockTracker() {
        this.stocks = new HashMap<>();
    }

    public void addStock(List<String> incomingItems) {
        for(String product : incomingItems) {
            stocks.put(product, stocks.getOrDefault(product, 0) + 1);
        }
    }
    
    public List<String> getLowStockItems(int threshold) {
        for(String lowProduct : stocks.entrySet()) {
            System.out.println(lowProduct);
        }
        return null;
    }
}


public class WarehouseInventoryStockAlertSystem {
    public static void main(String[] args) {

        List<String> list = List.of("Laptop", "mobile", "Laptop", "earboard");

        StockTracker t1 = new StockTracker();
        t1.addStock(list);

        t1.getLowStockItems(2);
    }
}
