package ScenarioBasedQuestions.Multithreading;

// public class OddEvenSynchronization {

//     public static void main(String[] args) {
//         OddEven oe = new OddEven();

//         Thread t1 = new Thread(() -> oe.Even());

//         Thread t2 = new Thread(() -> oe.odd());

//         t1.start();
//         t2.start();
//     }
// }

// class OddEven {

//     volatile boolean flag;

//     synchronized void Even() {
//         for (int i = 1; i <= 10; i++) {
//             if (i % 2 == 0) {
//                 System.out.println("Even: " + i);
//                 flag = true;

//                 while (flag == true) {
//              try{

//                 Thread.sleep(100);
//                     wait();
//                 } catch(Exception e) {}
//                 notifyAll();
//             }

               
//             }
//         }
//     }

//     synchronized void odd() {
//         for (int i = 1; i <= 10; i++) {
//             if (i % 2 != 0) {
//                 System.out.println("Odd: " + i);
//                 flag = false;

//                 while (flag == false) {
//              try{

//                 Thread.sleep(70);
//                     wait();
//                 } catch(Exception e) {}
//                 notifyAll();   
//             }
//             }
             
//         }
        
//     }
// }

class OddEvenPrinter {
    private int count = 1;
    private final int MAX_COUNT;

    public OddEvenPrinter(int maxCount) {
        this.MAX_COUNT = maxCount;
    }

    // Method executed by Thread-Odd
    public synchronized void printOdd() {
        while (count <= MAX_COUNT) {
            // If count is even, wait for the even thread to process it
            while (count % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Print odd number if within limit
            if (count <= MAX_COUNT) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                notify(); // Wake up the even thread
            }
        }
    }

    // Method executed by Thread-Even
    public synchronized void printEven() {
        while (count <= MAX_COUNT) {
            // If count is odd, wait for the odd thread to process it
            while (count % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Print even number if within limit
            if (count <= MAX_COUNT) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                notify(); // Wake up the odd thread
            }
        }
    }
}

public class OddEvenSynchronization {
    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(10);

        Thread oddThread = new Thread(printer::printOdd, "Thread-Odd");
        Thread evenThread = new Thread(printer::printEven, "Thread-Even");

        oddThread.start();
        evenThread.start();
    }
}