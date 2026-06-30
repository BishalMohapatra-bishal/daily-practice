package ECommercenotification;

import java.util.ArrayList;
import java.util.List;

abstract class Notification {
    private String orderId;
    private String messageContent;

    public Notification(String orderId, String messageContent) {
        this.orderId = orderId;
        this.messageContent = messageContent;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public abstract void send();
}

class EmailNotiication extends Notification {
    private final String emailAddress;

    public EmailNotiication(String orderId, String messageContent, String emailAddress) {
        super(orderId, messageContent);
        this.emailAddress = emailAddress;
    }

    @Override
    public void send() {
        System.out.println("Connecting toSMTP Server....");
        System.out.println("Email sent to " + emailAddress + " for Order" + getOrderId() + ": " + getMessageContent());
    }

}

class SMSNotification extends Notification {
    private final String phoneNumber;

    public SMSNotification(String orderId, String messageContent, String phoneNumber) {
        super(orderId, messageContent);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println("Connecting to Telecom SMS Gateway...");
        System.out.println("SMS sent to " + phoneNumber + " for Order " + getOrderId());
    }
}

public class ShopMaxOrderProcesser {
    public static void main(String[] args) {
        List<Notification> notificationQueue = new ArrayList<>();

        notificationQueue.add(new EmailNotiication("ORD101", "Your order has been shipped!", "user@example.com"));
        notificationQueue.add(new SMSNotification("ORD102", "Your order ORD102 is out for delivery.", "+1234567890"));

        System.out.println("------ Processing ShopMax Notifications ------");

        for(Notification notification : notificationQueue) {
            notification.send();
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}
