package ScenarioBasedQuestions.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class InventoryManager {
    private int availableStock;
    private final Lock lock = new ReentrantLock();

    public InventoryManager(int initialStock) {
        this.availableStock = availableStock;
    }

    public boolean reserveItem(String customerName, int quantity) {
        lock.lock();
        try {
            if (availableStock >= quantity) {
                System.out.println(Thread.currentThread().getName() + " -> [SUCCESS] " + customerName + " reserved "
                        + quantity + " item(s).");
                availableStock -= quantity;
                System.out.println("   Remaining stock: " + availableStock);
                return true;
            } else {
                System.out.println(Thread.currentThread().getName() + " -> [FAILED] " + customerName
                        + " tried to reserve " + quantity + " item(s), but only " + availableStock + " left.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getAvailableStock() {
        return availableStock;
    }

}

class CustomerTask implements Runnable {
    private final InventoryManager inventoryManager;
    private final String customerName;
    private final int quantity;

    public CustomerTask(InventoryManager inventoryManager, String customerName, int quantity) {
        this.inventoryManager = inventoryManager;
        this.customerName = customerName;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        inventoryManager.reserveItem(customerName, quantity);
    }

}

public class MultiCounterECommerceInventoryReservationSystem {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager(10);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("---Starting Flash Sale (Initial Stock: 10) ---");

        for(int i = 1; i <= 12; i++) {
            String customerName = "Customer-" + i;
            int requestedQty = (i % 2 == 0) ? 1 : 2;
            executor.submit(new CustomerTask(inventory, customerName, requestedQty));
        }

        executor.shutdown();
        try{
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("\n--- Sale Finished ---");
                System.out.println("Final Remaining Stock: " + inventory.getAvailableStock());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

