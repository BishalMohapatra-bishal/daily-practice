package Multithreading.multithreadingdailypractice;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedCounterUsingAtomicInteger {
    public static void main(String[] args) throws InterruptedException {

        CounterAI ai = new CounterAI();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i <= 10000; i++) {
                ai.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i <= 10000; i++) {
                ai.increment();
            }
        });

        t1.start();
        t2.start();

        // t1.join();
        // t2.join();

        Thread.sleep(1000);

        System.out.println(ai.counter.get());
    }
}

class CounterAI {
    AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }
    // int finalCount = counter.get();
}