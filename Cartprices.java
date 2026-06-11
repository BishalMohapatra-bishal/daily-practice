public class Cartprices {
    public static void main(String args[]) {
        double totalPrice = 00;
        double[] cartPrices = {12.99, 25.00, 4.50, 9.99};
        for(double price : cartPrices) {
            totalPrice = totalPrice + price;
        }
        System.out.println(totalPrice);
    }
}
