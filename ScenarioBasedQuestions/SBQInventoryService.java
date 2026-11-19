package ScenarioBasedQuestions;

public class SBQInventoryService {
    
}

class InventoryService {
    private int availableStock = 1;

    public boolean placeOrder(String userId) {
        if (availableStock > 0) {
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            availableStock--;
            System.out.println(userId + " successfully reserved the item.");
            return true;
        }
        System.out.println(userId + " failed: out of stock.");
        return false;
    }
}