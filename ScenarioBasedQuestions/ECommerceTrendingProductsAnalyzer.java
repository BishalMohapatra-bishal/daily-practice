package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrendingService {

    public List<String> getTopKProducts(List<String> purchases, int k) {
        if (purchases == null || purchases.isEmpty() || k <= 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> frequMap = new HashMap<>();
        for(String product : purchases) {
             frequMap.put(product, frequMap.getOrDefault(product, 0) + 1);
        }

        List<String> products = new ArrayList<>(frequMap.keySet());

        Collections.sort(products, (item1, item2) -> {
            int freq1 = frequMap.get(item1);
            int freq2 = frequMap.get(item2);

            if (freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            }

            return item1.compareTo(item2);
        });

        int resultSize = Math.min(k, products.size());
        return products.subList(0, resultSize);
    }
}

public class ECommerceTrendingProductsAnalyzer {
    public static void main(String[] args) {
        List<String> purchases = List.of(
            "Laptop", "Phone", "Laptop", "Headphone",
            "Phone", "Phone", "Mouse", "Laptop"
        );

        TrendingService service = new TrendingService();
        List<String> top2 = service.getTopKProducts(purchases, 3);

        System.out.println("--- Top Trending Products ---");
        System.out.println(top2);
    }
}
