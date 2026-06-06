package SmartAirlineBookingSystem;

import java.util.Scanner;

public class SmartAirline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String membership;
        double basePrice = 500;
        int age;
        int daysInAdvance;

        System.out.println("Enter your membership name : ");
        membership = sc.nextLine();
        System.out.println("Enter your age : ");
        age = sc.nextInt();
        System.out.println("Enter how many before you book : ");
        daysInAdvance = sc.nextInt();

        if (membership.equalsIgnoreCase("Platinum")) {
            basePrice *= 0.80;
        } else if (membership.equalsIgnoreCase("Gold")) {
            basePrice *= 0.90;
        } else if (membership.equalsIgnoreCase("Silver")) {
            basePrice *= 0.95;
        } else {
            System.out.println("Invalid membership!");
        }

        if (daysInAdvance > 30) {
            basePrice -= 50;
        }

        if (age <=2 && age >0) {
            basePrice = 50;
        } else if (age >= 65) {
            basePrice *= 0.90;
        }


        System.out.println("your final ticket price is after all available discount is : " + basePrice);
        sc.close();

    }

}
