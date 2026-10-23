package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThread {
   public static void main(String[] args) {
     // Normal Thread

    Thread t1 = new Thread(() -> {
        System.out.println("Normal Thread: " + Thread.currentThread().getName());
    });
    t1.start();

    // Virtual Thread
    // This is also a way to create the virtual thread but we dont create the virtual thread like this mostly

    Thread v1 = Thread.startVirtualThread(() -> {
        System.out.println("Virtual Thread: " + Thread.currentThread());
    });

    try {
        v1.join();
    } catch (InterruptedException e) {}

    // This is the way we mostly use to create the virtual thread
    // We can use virtual thread in situations like
    // API calls
    // DB calls

    ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for(int i = 0; i <= 5; i++) {
            executor.submit(() -> {
                System.out.println("Task executed by: " + Thread.currentThread());
            });
        }

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {}
        executor.shutdown();
   }   
}
