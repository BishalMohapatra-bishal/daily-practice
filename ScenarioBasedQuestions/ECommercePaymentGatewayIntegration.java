package ScenarioBasedQuestions;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        String lastFourDigits = (cardNumber != null && cardNumber.length() >= 4)
                ? cardNumber.substring(cardNumber.length() - 4)
                : "XXXX";

        System.out.printf("Processing credit card payment of Rs%.2f using card ending in ****%s%n",
                amount, lastFourDigits);
        return true;
    }
}

class UpiPayment implements PaymentMethod {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing UPI payment of Rs%.2f for ID %s%n" , amount, upiId);
        return true;
    }
}

class CheckoutService {
    public void completeOrder(PaymentMethod paymentMethod, double totalAmount) {
        System.out.println("--- Initiating Checkout ---");
        boolean success = paymentMethod.processPayment(totalAmount);

        if (success) {
            System.out.println("Order placed successfully!\n");
        } else {
            System.out.println("Payment failed. Please try again. \n");
        }
    }
}

public class ECommercePaymentGatewayIntegration {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();

        PaymentMethod card = new CreditCardPayment("1111222233334444");
        checkout.completeOrder(card, 1200.0); 
        
        PaymentMethod upi = new UpiPayment("Ajit@upi");
        checkout.completeOrder(upi, 450.0);
    }
}
