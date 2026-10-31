package Multithreading;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicArrayExample {
    public static void main(String[] args) throws InterruptedException {

        AtomicReferenceArray<String> sharedCache = new AtomicReferenceArray<>(3);

        sharedCache.set(0, "Empty");
        sharedCache.set(1, "Empty");
        sharedCache.set(2, "Empty");

        Thread t1 = new Thread(() -> {
            boolean success = sharedCache.compareAndSet(0, "Empty", "Data-From-Thread-1");
            System.out.println("Thread 1 update status: " + success);
        });

        Thread t2 = new Thread(() -> {
            boolean success = sharedCache.compareAndSet(0, "Empty", "Data-From-Thread-2");
            System.out.println("Thread 2 update status: " + success);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nFinal Cache State:");
        for (int i = 0; i < sharedCache.length(); i++) {
            System.out.println("Index " + i + ": " + sharedCache.get(i));
        }
    }
    
}
