package bt5;

public class SharedData {
    private String message;
    private boolean messageReady = false;

    public synchronized void sendMessage(String msg) {
        // Kiểm tra nếu tin nhắn chưa được đọc
        while (messageReady) {
            try {
                wait(); // Chờ đến khi tin nhắn được đọc
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread bị gián đoạn");
            }
        }

        this.message = msg;
        messageReady = true;
        System.out.println("Tin nhắn đã được gửi: " + msg);
        notify(); // Thông báo cho thread đợi
    }

    public synchronized void receiveMessage() {
        // Kiểm tra nếu chưa có tin nhắn
        while (!messageReady) {
            try {
                System.out.println("Người nhận đang chờ tin nhắn...");
                wait(); // Chờ đến khi có tin nhắn
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread bị gián đoạn");
            }
        }

        System.out.println("Người nhận đã nhận được tin nhắn: " + message);
        messageReady = false;
        notify(); // Thông báo cho thread gửi
    }


}
