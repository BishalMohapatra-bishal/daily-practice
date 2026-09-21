package LeatCodeProblems;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock buy = new BestTimeToBuyAndSellStock();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit Example 1: " + buy.maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit Example 2: " + buy.maxProfit(prices2));
    }
    
}
