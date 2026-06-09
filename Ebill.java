import java.util.Scanner;

public class Ebill {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
	
	for(int i = 1; i <= 3; i++) {    
	System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Enter Your " + i + " floor units:-");
        int units = scanner.nextInt();
	

        int meterCharge = 50;
        int demandCharge = 25;
        int dutyCharge = 4;
        double billAmount = 0.0;
        double billWithduty = 0.0;

        if (units <= 50) {
            System.out.println("Only electricity charges = " + (billAmount = 2.90 * units));

        } else if (units > 50 && units <= 200) {
            System.out.println("Only electricity charges = " + (billAmount = 4.70 * units));

        } else if (units > 200 && units <= 400) {
            System.out.println("Only electricity charges = " + (billAmount = 5.70 * units));

        } else if (units > 400) {
            System.out.println("Only electricity charges = " + (billAmount = 6.10 * units));

        } else {
            System.out.println("Enter the Correct units");
        }


        // System.out.println("The Bill Amount is:- " + billAmount);
        billWithduty = billAmount * (dutyCharge / 100.0);
        System.out.println("The Duty Charge is = " + billWithduty);

        System.out.println("Final bill is = " + (billWithduty + billAmount + meterCharge + demandCharge));

	System.out.println("-----------------------------------------------------------------------------------");

	}

    }
}