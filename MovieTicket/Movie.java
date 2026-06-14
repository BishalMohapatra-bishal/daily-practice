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

        double totalCost = numberOfTickets * movie.ticketPrice;

        movie.availableSeats -= numberOfTickets;

        System.out.println("Booking successfull! Total Cost: $");
     }
}
