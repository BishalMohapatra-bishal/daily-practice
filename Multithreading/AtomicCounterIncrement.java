package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterIncrement {
    public static void main(String[] args) {

        ACounter counter = new ACounter();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(counter.count);
    }
}

class ACounter {
    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }
}
