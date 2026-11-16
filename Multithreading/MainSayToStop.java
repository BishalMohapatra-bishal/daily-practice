package Multithreading;

public class MainSayToStop {
    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();

        Thread t1 = new Thread(w, "Worker");

        t1.start();

        Thread.sleep(1000);

        w.stopWorker();
    }
}

class Worker implements Runnable {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            // Do some background work
            System.out.println("Running.........");
        }
        System.out.println("Worker stopped.");
    }

    public void stopWorker() {
        running = false;
    }
}
