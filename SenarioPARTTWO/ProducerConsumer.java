package SenarioPARTTWO;

class Box {
    volatile Integer count = 0;
    volatile boolean flag = false;

    synchronized void producer(int value) throws InterruptedException {

        while (flag) {
            wait();
        }

        this.count = value;
        this.flag = true;
        System.out.println("Producer" + Thread.currentThread().getName() + " produced the value." + count);
        notify();
    }

    synchronized void consumer() throws InterruptedException {

        while (!flag) {
            wait();
        }

        System.out.println("Consumer" + Thread.currentThread().getName() + " consumed the value." + count);

        this.count = null;
        this.flag = false;
        notify();

    }
}

public class ProducerConsumer {
    public static void main(String[] args) {

        Box b1 = new Box();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {

                try {
                    Thread.sleep(100);
                    b1.producer(i);
                } catch (Exception e) {

                }

            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(70);
                    b1.consumer();
                } catch (Exception e) {

                }
            }
        });

        producer.start();
        consumer.start();

    }
}
