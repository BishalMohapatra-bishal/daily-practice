package Multithreading;

import java.util.concurrent.atomic.AtomicReference;

public class Cas {
    public static void main(String[] args) {
        LikeCounter likeCounter = new LikeCounter();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t4 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t5 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t6 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t7 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t8 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t9 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });

        Thread t10 = new Thread(() -> {
            for(int i = 1; i <= 10; i++) {
                likeCounter.like();
            }
        });
        

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();  
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
            Thread.sleep(3000);
        } catch(Exception e) {}

        System.out.println("Total Likes: " + likeCounter.getTotalLikes());
    }
}

class LikeCounter {

    AtomicReference<Integer> totalCount = new AtomicReference<>(0);

    public void like() {
        while (true) {

            Integer currentCount;
            Integer finalCount;

            // 1. We will capture the latest value of the totalCount.
            // Integer currentCount = totalCount.get(); 
            currentCount = totalCount.get();            

            // 2. Increment like counter by 1
            // Integer finalCount = currentCount + 1;
            finalCount = currentCount + 1;

            // 3. Check again, if the count is still what i saw.
            if (totalCount.compareAndSet(currentCount, finalCount)) {
                return;
            }

            // 4. If a thread reaches here, someone else must have updated thread
            // Re-try

            System.out.println("Conflict detected, Re-trying...");
        }
    }

    public int getTotalLikes() {
        return totalCount.get();
    }
}
