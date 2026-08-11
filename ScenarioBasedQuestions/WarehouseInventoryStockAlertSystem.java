package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StockTracker {
    private final Map<String, Integer> stocks;

    public StockTracker() {
        this.stocks = new HashMap<>();
    }

    public void addStock(List<String> incomingItems) {
        if (incomingItems == null) return; 
            
        for(String product : incomingItems) {
            if (product != null && !product.trim().isEmpty()) {
                String cleanItem = product.trim();
                stocks.put(cleanItem, stocks.getOrDefault(cleanItem, 0) + 1);
            }
        }
    }
    
    public List<String> getLowStockItems(int threshold) {
        List<String> lowStock = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : stocks.entrySet()) {
            if (entry.getValue() <= threshold) {
                lowStock.add(entry.getKey() + " (Count: " + entry.getValue() + ")");
            }
        }
        return lowStock;
    }

    public Map<String , Integer> getStock() {
        return stocks;
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
