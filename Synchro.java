class Counter {
     private int counte = 0;

        public synchronized void incerement() {
             counte++;
        }

        public int getCount() {
            return counte;
        }
}

class MyThread extends Thread {
        private Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                counter.incerement();
            }
        }
    }


public class Synchro {
    public static void main(String[] args) {
          Counter c1 = new Counter();

            MyThread t1 = new MyThread(c1);
            MyThread t2 = new MyThread(c1);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(c1.getCount());




    }

}

