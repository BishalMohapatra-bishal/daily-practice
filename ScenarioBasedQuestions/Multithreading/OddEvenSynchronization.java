package ScenarioBasedQuestions.Multithreading;

public class OddEvenSynchronization {

    public static void main(String[] args) {
        OddEven oe = new OddEven();

        Thread t1 = new Thread(() -> oe.Even());

        Thread t2 = new Thread(() -> oe.odd());

        t1.start();
        t2.start();
    }
}

class OddEven {

    volatile boolean flag;

    synchronized void Even() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i);
                flag = true;

                while (flag == true) {
             try{

                Thread.sleep(100);
                    wait();
                } catch(Exception e) {}
                notifyAll();
            }

               
            }
        }
    }

    synchronized void odd() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd: " + i);
                flag = false;

                while (flag == false) {
             try{

                Thread.sleep(70);
                    wait();
                } catch(Exception e) {}
                notifyAll();   
            }
            }
             
        }
        
    }
}