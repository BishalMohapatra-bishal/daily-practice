package SenarioPARTTWO;

import java.util.Comparator;
import java.util.List;

class Order{
    private int orderId;
    private boolean isVip;
    private double amount;
    private int orderDaysAgo;

    public Order(int orderId, boolean isVip, double amount, int orderDaysAgo) {
        this.orderId = orderId;
        this.isVip = isVip;
        this.amount = amount;
        this.orderDaysAgo =orderDaysAgo;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isVip() {
        return isVip;
    }

    public double getAmount() {
        return amount;
    }

    public int getOrderDaysAgo() {
        return orderDaysAgo;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", isVip=" + isVip + ", amount=" + amount + ", orderDaysAgo="
                + orderDaysAgo + "]";
    }
    
}

class OrderFulfillmentService {

    public List<Order> getPrioritizedOrders(List<Order> orders) {
        if (orders == null) {
            return List.of();
        }

        return orders.stream()
                     .filter(o -> o.getAmount() > 200)
                     .sorted(Comparator.comparing(Order::isVip).reversed()
                    .thenComparing(Order::getOrderDaysAgo, Comparator.reverseOrder())
                )
                .toList();
    }
}
public class ECommerceCustomerOrderPrioritization {
    public static void main(String[] args) {
        List<Order> incomingOrders = List.of(
            new Order(1, false, 50.0, 2),
            new Order(2, true, 201.0, 1),
            new Order(3, true, 553.0, 1),
            new Order(4, true, 51.0, 4)
        );

        OrderFulfillmentService service = new OrderFulfillmentService();
        List<Order> prioritized = service.getPrioritizedOrders(incomingOrders);

        System.out.println("-------Prioritized Fulfillment Queue-------");
        prioritized.forEach(System.out::println);
    }
}
