package bt3;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}