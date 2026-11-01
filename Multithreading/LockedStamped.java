package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class LockedStamped {
    public static void main(String[] args) {

        SResource sr = new SResource();

        Thread r1 = new Thread(() -> sr.read());
        Thread r2 = new Thread(() -> sr.read());
        Thread r3 = new Thread(() -> sr.read());

        Thread w1 = new Thread(() -> sr.write(5));
        Thread w2 = new Thread(() -> sr.write(7));
        Thread w3 = new Thread(() -> sr.write(9));

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();
        w3.start();
    }
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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        if (lock.validate(stamp) == false) {
            // followOver logic
            stamp = lock.readLock();

            try {
                currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }
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
