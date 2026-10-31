package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class LockedStamped {
    
}

class SResource {
    private int value = 0;

    // ReadWriteLock rwLock = new ReentrantReadWriteLock();
    // Lock rl = rwLock.readLock(); //shared
    // Lock wl = rwLock.writeLock(); //Exclusive

    StampedLock lock = new StampedLock();

    public int read() {
        long stamp = lock.tryOptimisticRead();
        
        int currentValue = value;

        if (lock.validate(stamp) == false) {
            // followOver logic
            stamp = lock.readLock();
        }
        System.out.println(currentValue);
        return currentValue;
        
    }

    public void write(int newValue) {
        long stamped = lock.writeLock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " changes value : " + value);
        } finally {
            lock.unlockWrite(stamped);
        }
        
    }
}
