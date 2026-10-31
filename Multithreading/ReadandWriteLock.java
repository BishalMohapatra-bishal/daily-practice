package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadandWriteLock {
    public static void main(String[] args) {
        SharedResourse sr = new SharedResourse();

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

class SharedResourse {
    private int value = 0;

    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock rl = rwLock.readLock(); //shared
    Lock wl = rwLock.writeLock(); //Exclusive

    public int read() {
        rl.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " read value : " + value);
            return value;
        } finally {
            rl.unlock();
        }
        
    }

    public void write(int newValue) {
        wl.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " changes value : " + value);
        } finally {
            wl.unlock();
        }
        
    }
}
