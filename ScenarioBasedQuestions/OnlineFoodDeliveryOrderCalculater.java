package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String itemName;
    private double price;
    private String category;

    public MenuItem(String itemName, double price, String category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

}

class OrderProcessor {
    public double calculateTotal(List<MenuItem> items) {
         if (items == null || items.isEmpty()) {
                return 0.0;
            }

        double subPrice = 0.0;

        for(MenuItem item : items) {
            double itemPrice = item.getPrice();

            if ("Beverage.".equalsIgnoreCase(item.getCategory())) {
                itemPrice = itemPrice * 0.90;
            }

            subPrice += itemPrice;
        }

        if (subPrice > 30.0) {
            System.out.println("-> Order eligible for Rs5.00 flat discount!");
            subPrice -= 5.0;
        }
           return subPrice;
    }
}

public class OnlineFoodDeliveryOrderCalculater {
    public static void main(String[] args) {
        MenuItem i1 = new MenuItem("Burger", 80.0, "Main");
        MenuItem i2 = new MenuItem("Pizza", 120.0, "Main");
        MenuItem i3 = new MenuItem("Cold Coffee", 50.0, "Beverage");
        MenuItem i4 = new MenuItem("Ice Cream", 35.0, "Desert");

        List<MenuItem> items = new ArrayList<>();
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);

        OrderProcessor order = new OrderProcessor();
        System.out.println("---Order Summery---");
        for(MenuItem item : items) {
            System.out.printf("- %s (%s): $%.2f%n", item.getItemName(), item.getCategory(), item.getPrice());
        }

        double finalBill = order.calculateTotal(items);

        System.out.println("--------------------------------------------");
        System.out.printf("Final Total Bill: $%.2f%n", finalBill);
    }
    
}
