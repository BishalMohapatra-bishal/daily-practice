package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;

class Notification<T> {
    private final String recipient;
    private final T payload;

    public Notification(String recipient, T payload) {
        this.recipient = recipient;
        this.payload = payload;
    }

    public String getRecipient() {
        return recipient;
    }

    public T getPayload() {
        return payload;
    }

    public void send() {
        System.out.println("Sending alert to: " + recipient);
    }
}

class EmailNotification extends Notification<String> {
    public EmailNotification(String recipient, String emailBody) {
        super(recipient, emailBody);
    }

    @Override
    public void send() {
        super.send();
        System.out.println("[EMAIL CONTENT]: " + getPayload());
    }
}

class SmsNotification extends Notification<Long> {

    public SmsNotification(String recipient, Long verificationCode) {
        super(recipient, verificationCode);
    }

    @Override
    public void send() {
        super.send();
        System.out.println(" [SMS CODE] " + getPayload());
    }
}

class NotificationManager {

    public void sendAll(List<? extends Notification<?>> notifications) {
        System.out.println("--- Dispatching Queue ---");
        for (Notification<?> notification : notifications) {
            notification.send();
            System.out.println("---------------------------");
        }
    }
}

public class GenericNotificationService {
    public static void main(String[] args) {
        List<Notification<?>> queue = new ArrayList<>();

        queue.add(new EmailNotification("bishal@gmail.com", "Your statement is ready to view."));
        queue.add(new SmsNotification("+91-1234567890", 849201L));

        NotificationManager manager = new NotificationManager();
        manager.sendAll(queue);
    }
}
