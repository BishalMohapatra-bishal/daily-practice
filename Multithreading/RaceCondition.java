package Multithreading;

public class RaceCondition {
public static void main(String[] args) {
    Counters c = new Counters();

    Thread t1 = new Thread(() -> {
        for(int i = 0; i < 10000; i++) {
            c.increment();
        }
    });

    Thread t2 = new Thread(() -> {
        for(int i = 0; i < 10000; i++) {
            c.increment();
        }
    });

    t1.start();
    t2.start();

    try {
        Thread.sleep(2000);
    } catch (Exception e) {
       e.printStackTrace();
    }
    

    System.out.println(c.count);
}
    
}

class Counters {
    int count;

    public void increment() {
         count++;
    } 
}