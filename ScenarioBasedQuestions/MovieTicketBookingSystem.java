package ScenarioBasedQuestions;

import java.util.List;

class Ticket {
    private String customerName;
    private String seatNumber;
    private boolean isVip;

    public Ticket(String customerName, String seatNumber, boolean isVip) {
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        this.isVip = isVip;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean getIsVIP() {
        return isVip;
    }

    public static double calculatePrice( Ticket ticket, int noOfSeat) {
        double ticketCost;

        if (ticket.isVip) {
            return ticketCost = noOfSeat * 200;
        } else {
            return ticketCost = noOfSeat * 150;
        }
    }

}

class MovieTicketBookingSystem {
    public static void main(String[] args) {
    Ticket t1 = new Ticket("Apple Kumar", "AK101", true);
    Ticket t2 = new Ticket("Orange Kumari", "OK102", true);
    Ticket t3 = new Ticket("Banana Kumar", "BK103", false);
    Ticket t4 = new Ticket("Lichi Kumari", "LK104", true);
    Ticket t5 = new Ticket("Mango Kumar", "MK105", false);

    List<Ticket> l1 = List.of(t1, t2, t3, t4, t5);
    
    for (Ticket tickets : l1) {
        double totalPrice = Ticket.calculatePrice(tickets, 2);
        System.out.println("Customer Name: " + tickets.getCustomerName() + " is trying to book tickets for seat number: " + tickets.getSeatNumber() + ". And total price is: Rs" + totalPrice);
    }

    }
   
}