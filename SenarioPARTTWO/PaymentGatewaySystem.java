package SenarioPARTTWO;

abstract class PaymentProcessor {

    public abstract void processPayment(double amount);

    public void printReceipt(double amount) {
        System.out.println("Receipt generated for amount: Rs" + amount);
    }
}

interface Refundable {
    void refund(double amount);
}

class CreditCardPayment extends PaymentProcessor implements Refundable{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of Rs" +amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding Rs" + amount + " to Credit Card");
    }
}

public class PaymentGatewaySystem {
    public static void main(String[] args) {
        CreditCardPayment cc = new CreditCardPayment();

        cc.processPayment(150);
        cc.printReceipt(150);
        cc.refund(50);
    }
}
