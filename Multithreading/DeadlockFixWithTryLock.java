package Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockFixWithTryLock {

    // Bank Account class containing its own ReentrantLock
    static class Account {
        private final String name;
        private final Lock lock = new ReentrantLock();

        public Account(String name) {
            this.name = name;
        }

        public Lock getLock() {
            return lock;
        }

        public String getName() {
            return name;
        }
    }

    // Safe transfer method using tryLock to prevent permanent deadlocks
    public static boolean transfer(Account from, Account to, int amount) {
        long startTime = System.currentTimeMillis();
        long timeoutMs = 2000; // Give up trying after 2 seconds

        while (true) {
            boolean acquiredFrom = false;
            boolean acquiredTo = false;

            try {
                // Step 1: Try to acquire the first lock with a small timeout
                acquiredFrom = from.getLock().tryLock(50, TimeUnit.MILLISECONDS);
                if (acquiredFrom) {
                    // Step 2: Try to acquire the second lock
                    acquiredTo = to.getLock().tryLock(50, TimeUnit.MILLISECONDS);
                    if (acquiredTo) {
                        // SUCCESS: We hold both locks safely!
                        System.out.println(Thread.currentThread().getName() + 
                            ": Successfully acquired both locks. Transferring from " + 
                            from.getName() + " to " + to.getName());
                        
                        // Simulate transaction work
                        Thread.sleep(100); 
                        return true;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                return false;
            } finally {
                // CRITICAL: If we managed to grab one lock but failed to grab the other,
                // we must release the one we hold immediately so we don't block others.
                if (acquiredTo) {
                    to.getLock().unlock();
                }
                if (acquiredFrom) {
                    from.getLock().unlock();
                }
            }

            // If we couldn't acquire both locks, check if we've exceeded our total timeout
            if (System.currentTimeMillis() - startTime > timeoutMs) {
                System.out.println(Thread.currentThread().getName() + 
                    ": Timed out trying to acquire locks for transfer. Aborting.");
                return false;
            }

            // Small random back-off sleep before retrying to prevent "livelock" 
            // (where both threads keep failing and retrying at the exact same millisecond)
            try {
                Thread.sleep(20 + (long)(Math.random() * 30));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Account accountA = new Account("Account-A");
        Account accountB = new Account("Account-B");

        // Thread 1 wants to transfer from A -> B
        Thread t1 = new Thread(() -> {
            transfer(accountA, accountB, 100);
        }, "Thread-1 (A->B)");

        // Thread 2 wants to transfer from B -> A at the exact same time
        Thread t2 = new Thread(() -> {
            transfer(accountB, accountA, 50);
        }, "Thread-2 (B->A)");

        t1.start();
        t2.start();
    }
}