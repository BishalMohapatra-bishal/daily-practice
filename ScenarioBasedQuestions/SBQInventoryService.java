package ScenarioBasedQuestions;

// public class SBQInventoryService {
//     public static void main(String[] args) throws InterruptedException {
//         InventoryService is = new InventoryService();

//         Thread t1 = new Thread(() -> is.placeOrder(Thread.currentThread().getName()));
//         Thread t2 = new Thread(() -> is.placeOrder(Thread.currentThread().getName()));

//         t1.start();
//         t2.start();

//         t1.join();
//         t2.join();

//         System.out.println(is.getStock());
//     }
// }

// class InventoryService {
//     private int availableStock = 1;

//     public boolean placeOrder(String userId) {
//         if (availableStock > 0) {
            
//             try {
//                 Thread.sleep(50);
//             } catch (InterruptedException e) {
//                 Thread.currentThread().interrupt();
//             }
//             availableStock--;
//             System.out.println(userId + " successfully reserved the item.");
//             return true;
//         }
//         System.out.println(userId + " failed: out of stock.");
//         return false;
//     }

//     public int getStock() {
//         return availableStock;
//     }
// }

import java.util.Objects;

class SynchronizedInventoryService {
    private int availableStock = 1;
    private final Object stockLock = new Object();

    public boolean placeOrder(String userId) {
        Objects.requireNonNull(userId, "userId must not be null");

        boolean reserved;
        synchronized (stockLock) {
            if (availableStock <= 0) {
                System.out.println(userId + " failed: out of stock.");
                return false;
            }
            availableStock--;
            reserved = true;
        }

        // Simulated downstream work outside the lock
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(userId + " successfully reserved the item.");
        return reserved;
    }
}