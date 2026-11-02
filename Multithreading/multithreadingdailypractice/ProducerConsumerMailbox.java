package Multithreading.multithreadingdailypractice;

public class ProducerConsumerMailbox {
     public static void main(String[] args) {
        Mailbox box = new Mailbox();

        Thread producer = new Thread(() -> {
            String[] message = {"Hello", "world", "java", "Threads", "DONE"};
            for(String msg : message) {
            box.deposite(msg);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            String msg = "";
            while (!msg.equals("DONE")) {
                msg = box.retrive();
                try { Thread.sleep(400); } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
     }
}

class Mailbox {
    private String message;
    private boolean hasMessage = false;

    public void deposite(String newMessage) {
        synchronized (this) {
            while (hasMessage) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
        }

        message = newMessage;
        hasMessage = true;
        System.out.println("Deposited: " + message);

        this.notifyAll();
        }
    }

    public String retrive() {
        
        synchronized (this) {
            while (!hasMessage) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        hasMessage = false;
        System.out.println("Retrieved: " + message);

        this.notifyAll();
        return message;
        }
    }

}
