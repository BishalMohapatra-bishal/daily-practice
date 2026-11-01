package Multithreading.multithreadingdailypractice;

public class TheMultiThreadedCounter {
    public static void main(String[] args) {
        Counters c = new Counters();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++) {
                c.increaseCount();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++) {
                c.increaseCount();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e) {}
        

        System.out.println("Total count is : " + c.getCount());
    }
    
}

class Counters {
    private int count;

    public void increaseCount() {
        synchronized(this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
