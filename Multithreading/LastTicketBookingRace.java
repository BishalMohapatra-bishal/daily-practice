package Multithreading;

public class LastTicketBookingRace {
    public static void main(String[] args) {

        TicketCounter tc= new TicketCounter();
        Thread t1 = new Thread(() -> tc.bookTicket(Thread.currentThread().getName()), "Alice");

        Thread t2 = new Thread(() -> tc.bookTicket(Thread.currentThread().getName()), "Bob");
        
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}

class TicketCounter {
    private int availableTickets = 1;

    public synchronized void bookTicket(String user) {
        if (availableTickets > 0) {
            System.out.println(user + " is booking the ticket...");
            availableTickets--;
            System.out.println(user + " booked! Remaining: " + availableTickets);
        } else {
            System.out.println("Sorry " + user + ", sold out!");
        }
    }
}
