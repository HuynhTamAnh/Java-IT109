package bt5;

public class SmsSubscriber implements Observer {
    private String phoneNumber;

    public SmsSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        System.out.println("Gửi SMS đến " + phoneNumber + ": " + message);
    }
}