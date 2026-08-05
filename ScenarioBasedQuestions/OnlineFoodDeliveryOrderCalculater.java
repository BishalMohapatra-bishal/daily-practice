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

        double disPrice = 0.0;

        for(MenuItem item : items) {
            double itemPrice = item.getPrice();
        }
           
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
        order.calculateTotal(items);
    }
    
}
