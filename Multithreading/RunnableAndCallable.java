package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class RunnableAndCallable {
    public static void main(String[] args) throws InterruptedException {

        Execute ee = new Execute();
        
        Runnable r = () -> {
            for(int i = 1; i <= 10; i++) {
                ee.email(Thread.currentThread().getName());
            }
        };

        Callable<Integer> cc = () -> ee.getScore();
        FutureTask<Integer> task = new FutureTask<>(cc);

        Thread t1 = new Thread(r, "Bob");
        Thread t2 = new Thread(task);

        t1.start();

         try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        
        t2.start();

        t1.join();
        t2.join();

        try{
            System.out.println(task.get());
        } catch (Exception e) {}
        
    }
}

class Execute {

    private volatile int score;

    public void email(String name) {
        System.out.println("Send email to: " + name);
        this.score++;
    }

    public int getScore() {
        return score;
    }

}
