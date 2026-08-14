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

        StockTracker tracker = new StockTracker();

        List<String> list = List.of("Monitor", "Keyword", "Mouse", "Monitor", "Monitor", "Keyword", "Cable");

        System.out.println("--- Processing Incoming Shipment ---");
        tracker.addStock(list);
        
        System.out.println("\n--- Current Inventory Levels ---");
        for (Map.Entry<String, Integer> entry : tracker.getStock().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " units");
        }

        System.out.println("\n--- Low Stock Alert (Quantity <= 2) ---");
        List<String> lowStock =tracker.getLowStockItems(2);
        for (String item : lowStock) {
            System.out.println("⚠️ Alert: " + item);
        }
    }
}
