package bt3;

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}