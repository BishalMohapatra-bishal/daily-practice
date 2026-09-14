package SenarioPARTTWO;

import java.util.Scanner;

class Ride {
    protected String customerName;
    protected String rideId;
    protected double distanceKm;
    public static final String APP_NAME = "RAPIDO APP";

    public Ride(String customerName, String rideId, double distanceKm) {
        if (customerName == null) {
            System.out.println("Customer name cannnot be null!");
        } else {
            this.customerName = customerName;
        }

        if (rideId == null) {
            System.out.println("Ride ID cannot be null!");
        } else {
            this.rideId = rideId;
        }

        if (distanceKm <= 0) {
            System.out.println("Distance cannot be negative or zero!");
        } else {
            this.distanceKm = distanceKm;
        }
    }

    void calculateFare() {
        System.out.println("Your total fair");
    }

    void displayRideDetails() {
        System.out.println("Customer Name: " + customerName 
                                + "\nRide ID: " + rideId
                                + "\n Distance: " + distanceKm
                                + "\n App: " + APP_NAME);
    }
}

class BikeRide extends Ride{

    protected double costPerKm = 10.0;

    public BikeRide(String customerName, String rideId, double distanceKm) {
        super(customerName, rideId, distanceKm);
    }

    @Override 
    public void calculateFare() {
        System.out.println("Bike Ride Fare is = Rs" + distanceKm * costPerKm);
    }
}

class AutoRide extends Ride{
    protected  double baseFare = 30.0;
    protected  double costPerKm = 12.0;

    public AutoRide(String customerName, String rideId, double distanceKm) {
        super(customerName, rideId, distanceKm);
    }

    @Override 
    public void calculateFare() {
        System.out.println("Auto Ride Fare is = Rs" + baseFare + (distanceKm * costPerKm));
    }
}

class PremiumBikeRide extends Ride{

    protected double costPerKm = 18.0;
    protected double convenienceFee = 25.0;
    protected double minimumDistance = 3.0;


    public PremiumBikeRide(String customerName, String rideId, double distanceKm) {
        super(customerName, rideId, distanceKm);

        if (distanceKm < minimumDistance) {
            System.out.println("Premium rides require a minimum distance of 3 km.");
            throw new IllegalArgumentException();
        }
    }

    @Override 
    public void calculateFare() {
        System.out.println("Premium Bike Fare is = Rs" + (distanceKm * costPerKm) + convenienceFee);
    }
}

public class RapidoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Ride Type:");
        System.out.println("1) Bike");
        System.out.println("2) Auto");
        System.out.println("3) Premium Bike");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice selected.");
            sc.close();
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Ride ID: ");
        String rideId = sc.nextLine();

        System.out.print("Enter Distance: ");
        double distance = sc.nextDouble();

        System.out.println(); // Spacing

        try {
            Ride ride = null;
            switch (choice) {
                case 1:
                    ride = new BikeRide(name, rideId, distance);
                    break;
                case 2:
                    ride = new AutoRide(name, rideId, distance);
                    break;
                case 3:
                    ride = new PremiumBikeRide(name, rideId, distance);
                    break;
            }

            if (ride != null) {
                ride.displayRideDetails();
                System.out.println();
                ride.calculateFare();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

// //////////////////////////////////////////////////COMPLETLY WRONG APPROACH///////////////////////////////////////////////////
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Menu: \n 1>Bike Ride \n 2>Auto Ride \n 3>Premium Bike Ride");

//         System.out.println("Chose your option");
//         int choice = sc.nextInt();

//         switch (choice) {
//             case 1:
//                 input(sc);
//                 Ride br = new BikeRide(null, null, choice)
//                 break;
//             case 2:
//                 input(sc);
//                 break;
//             case 3:
//                 input(sc);
//                 break;    
//             default:
//                 System.out.println("Please chose the right option!!");
//                 break;
//         }
//          sc.close();
//     }

//     private static void input(Scanner scanner) {
//         scanner.nextLine();
//         System.out.println("Entrer Your Name: ");
//         String name = scanner.nextLine();
        
//         System.out.println("Enter your rideID: ");
//         String id = scanner.nextLine();

//         System.out.println("Enter your KM: ");
//         double km = scanner.nextInt();

//         System.out.println("User Details: \n UserName: " + name + "\n UserId: " + id + "\n KM: " + km);
//         Ride r = new Ride(name, id, km);
//     }
// }
