package Multithreading.multithreadingdailypractice;

import java.beans.IntrospectionException;

public class ProducerConsumerMailbox {
     public static void main(String[] args) {
        Mailbox box = new Mailbox();

        Thread producer = new Thread(() -> {
            String[] message = {"Hello", "world", "java", "Threads", "DONE"};
            for(String msg : message) {
                
                try {
                     box.deposite(msg); 
                     Thread.sleep(200); 
                } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            String msg = "";
            while (!msg.equals("DONE")) {
                try {
                    msg = box.retrive();
                    Thread.sleep(400); 
                } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
     }
}

class Mailbox {
    private String message;
    private boolean hasMessage = false;

    public void deposite(String newMessage) throws InterruptedException {
        while (hasMessage) {
            wait();
        }

        message = newMessage;
        hasMessage = true;
        System.out.println("Deposited: " + message);
        notify();
    }

    public String retrive() throws InterruptedException {
        while (!hasMessage) {
            wait();
        }
        hasMessage = false;
        System.out.println("Retrieved: " + message);
        notify();
        return message;
    }

}
