package Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLocks {

}

class Helper {

    Lock lock = new ReentrantLock();

    void resouceA() {

        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println("ResourceA hold by: " + Thread.currentThread().getName());
                } finally {
                    lock.unlock();
                }
            } else {

            }
        } catch (InterruptedException e) {
        }

    }

    void resourceB() {
        System.out.println("ResourceB..............");
    }
}
