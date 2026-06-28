package TheRaceTo100;
class NumberPrinter implements Runnable {
    private String threadName;
    private boolean printEven;

    public NumberPrinter(String name, boolean printEven) {
        this.threadName = name;
        this.printEven = printEven;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            if (printEven && i % 2 == 0) {
                System.out.println(threadName + ": " + i);
            } else if (!printEven && i % 2 != 0) {
                System.out.println(threadName + ": " + i);
            }
        }
    }
}

public class Race {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter("Thread-Even", true));
        Thread thread2 = new Thread(new NumberPrinter("Thread-Odd", false));

        thread1.start();
        thread2.start();
    }
}
