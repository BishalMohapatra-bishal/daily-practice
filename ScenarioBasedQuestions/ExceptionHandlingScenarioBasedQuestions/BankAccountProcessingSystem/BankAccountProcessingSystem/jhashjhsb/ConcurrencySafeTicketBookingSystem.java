package ScenarioBasedQuestions.ExceptionHandlingScenarioBasedQuestions.BankAccountProcessingSystem.BankAccountProcessingSystem.jhashjhsb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class TicketCounter {
    private final AtomicInteger availableSeats;
    private final AtomicInteger totalBooked;
    
    public TicketCounter(int initialSeats) {
        this.availableSeats = new AtomicInteger(initialSeats);
        this.totalBooked = new AtomicInteger(0);
    }

    public boolean bookSeat(String passengerName) {
        while (true) {
            int currentSeats = availableSeats.get();

            if (currentSeats <= 0) {
                System.out.println("Booked failed for " + passengerName + ": sold out!");
                return false;
            }

            if (availableSeats.compareAndSet(currentSeats, currentSeats - 1)) {
                totalBooked.incrementAndGet();
                System.out.printf("Ticket booked for %s | Remaining seats: %d%n",
                    passengerName, currentSeats - 1);
                    return true;
            }
        }
             
    }

    public int getAvailableSeats() {
        return availableSeats.get();
    }

    public int getTotalBooked() {
        return totalBooked.get();
    }
}

public class ConcurrencySafeTicketBookingSystem {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter t1 = new TicketCounter(3);

        String[] passengers = {"Bishal", "Amit", "Priya", "Rahul", "Sneha"};
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("--- Starting Concurrent Bookings ---");

        for (String passenger : passengers) {
            executor.submit(() -> t1.bookSeat(passenger));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n--- Final Booking Summery ---");
        System.out.println("Total Booked: " + t1.getTotalBooked());
        System.out.println("Seats Remaining: " + t1.getAvailableSeats());
    }
}
