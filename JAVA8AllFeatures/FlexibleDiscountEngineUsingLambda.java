package JAVA8AllFeatures;

@FunctionalInterface 
interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

class CheckoutService {
    public double calculateFinalPrice(double totalAmount, DiscountStrategy discountStrategy) {

        if (discountStrategy == null) {
            return totalAmount;
        }
       return discountStrategy.applyDiscount(totalAmount);
    }
}

public class FlexibleDiscountEngineUsingLambda {
    public static void main(String[] args) {
        double orderTotal = 1200;
        CheckoutService checkout = new CheckoutService();

        DiscountStrategy flatDiscount = total -> total - 15.0;

        DiscountStrategy percentageDiscount = total -> total * 0.90;

        DiscountStrategy thresholdDiscount = total -> {
            if (total > 100.0) {
                return total * 0.80;
            }
            return total;
        };

        System.out.println("Original Total: Rs" + orderTotal);
        System.out.println("--------------------------------");
        System.out.println("After flat Rs15 Discount: Rs" + checkout.calculateFinalPrice(orderTotal, flatDiscount));
        System.out.println("After 10% Discount: Rs" + checkout.calculateFinalPrice(orderTotal, percentageDiscount));
        System.out.println("20% off > Rs1200" + checkout.calculateFinalPrice(orderTotal, thresholdDiscount));
    }
}
