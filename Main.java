// Parent Class
class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println("Processing standard payment of: Rs " + amount);
    }
}

// Child Class 1: Credit Card (Flat Rs 2.50 Fee)
class CreditCardPayment extends Payment {
    
    CreditCardPayment(double amount) {
        super(amount); 
    }

    // FIX: Exactly matches the parent method signature
    @Override
    public void processPayment() {
        double finalAmount = amount + 2.50;
        System.out.println("Processing Credit Card payment of: Rs " + finalAmount + " (Includes Rs 2.50 fee)");
    }
}

// Child Class 2: Bank Transfer (1% Fee)
class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    // FIX: Exactly matches the parent method signature
    @Override
    public void processPayment() {
        double fee = amount * 0.01;
        double finalAmount = amount + fee;
        System.out.println("Processing Bank Transfer payment of: Rs " + finalAmount + " (Includes 1% fee of Rs " + fee + ")");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Test Credit Card Payment
        Payment ccPayment = new CreditCardPayment(100.00);
        ccPayment.processPayment(); // Outputs Rs 102.50
        
        System.out.println("------------------------------------------------");

        // Test Bank Transfer Payment
        Payment bankPayment = new BankTransferPayment(500.00);
        bankPayment.processPayment(); // Outputs Rs 505.00
    }
}