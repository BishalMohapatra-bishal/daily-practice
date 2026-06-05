import java.util.Scanner;

public class AtmWithdrawal {
    public static void main(String[] args) {
        int a = 20;
        int b = 50;
        int c = 100;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount you want to deposit");
        double deposit = sc.nextDouble();
        if ( deposit <= 0 ) {
            System.out.println("This amount cant be proceed");
        }

        System.out.println("Enter the amount you want to withdraw");
        double withdraw = sc.nextDouble();
        if (deposit >= withdraw) {

            if (withdraw % a == 0) {
                System.out.println("Proceed with the withdrawal amount Rs: " + withdraw);
            } else if (withdraw % b == 0) {
                System.out.println("Proceed with the withdrawal amount Rs: " + withdraw);
            } else if (withdraw % c == 0) {
                System.out.println("Proceed with the withdrawal amount Rs: " + withdraw);
            } else {
                System.out.println("The amount cannot be proceed");
            }

        } else {
            System.out.println("Insufficient balance");
        }



    }
}
