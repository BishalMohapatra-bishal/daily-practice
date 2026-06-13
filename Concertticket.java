import java.util.Scanner;

public class Concertticket {
    public static boolean canBuyTicket(int ticketRequested) {
        return ticketRequested <= 6 && ticketRequested > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of tickets you want to buy.");
        int tickets = sc.nextInt();
        
        if (canBuyTicket(tickets)) {
            System.out.println("You can get " + tickets + " tickets.");
        } else {
            System.out.println("This much tickets are not allowed for a single person.");
        }
        sc.close();
    }
}
