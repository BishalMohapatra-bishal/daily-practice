package MovieTicket;

 class Movie {

    String title;
    double ticketPrice;
    int availableSeats;

    public Movie(String title, double ticketPrice, int availableSeats) { 
        this.title = title;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }
    
}

class TicketBookingSystem {

     public void bookTickets(Movie movie, int numberOfTickets) {

        System.out.println("Attempting to book " + numberOfTickets + " tickets for " + movie.title); 

        if (movie.availableSeats != 0 && numberOfTickets <= movie.availableSeats) { 
        
            double totalCost = numberOfTickets * movie.ticketPrice;

            System.out.println("Booking successfull! Total Cost: Rs" + totalCost);

             movie.availableSeats -= numberOfTickets;  

            // System.out.println("Available seats are : " + movie.availableSeats);
        } else {
            System.out.println(numberOfTickets + " seats are not available.");
        }

     }
}

public class Main {
    public static void main(String[] args) {
        Movie avatar = new Movie("Avatar 3", 250.00, 5);

        TicketBookingSystem system = new TicketBookingSystem();
        system.bookTickets(avatar, 6);

        System.out.println("Seat left for " + avatar.title + " is " + avatar.availableSeats);
    }
}


