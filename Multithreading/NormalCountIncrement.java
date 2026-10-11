package Multithreading;

public class NormalCountIncrement {
public static void main(String[] args) {

    Counter counter = new Counter();

    Thread t1 = new Thread(() -> {
        for(int i = 1; i <= 10000; i++) {
            counter.increment();
        }
    }) ;

    Thread t2 = new Thread(() -> {
        for(int i = 1; i <= 10000; i++) {
            counter.increment();
        }
    });
    t1.start();
    t2.start();

    try{
        Thread.sleep(2000);
    } catch(InterruptedException e) {

    }
    System.out.println(counter.count);
}
    
}

class Counter {
     int count;

    void increment() {
        count++;
    }
}
