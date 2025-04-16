package bt5;
//Triển khai mẫu thiết kế Observer để quản lý hệ thống thông báo.
//
//
//
//Yêu cầu:
//
//Tạo một interface Observer
//Với phương thức update(String message)
//Tạo interface Subject để quản lý danh sách các observer và thông báo cho chúng khi có thay đổi gồm các phương thức trừu tượng sau:
//registerObserver(Observer o): Thêm người nhận thông báo
//removeObserver(Observer o): Xóa người nhận
//notifyObservers(String message): Gửi thông báo đến tất cả observer
//Tạo lớp NotificationSystem implements Subject để triển khai các phương thức trên.
//Tạo một số lớp Observer cụ thể và thử nghiệm. Ví dụ
//EmailSubscriber implements Observer: Nhận thông báo qua email.
//SmsSubscriber implements Observer: Nhận thông báo qua tin nhắn
//Tạo lớp Main: Để kiểm tra hệ thống gửi thông báo hoạt động đúng.
public class Main {
    public static void main(String[] args) {

        NotificationSystem notificationSystem = new NotificationSystem();

        Observer emailSubscriber1 = new EmailSubscriber("user1@example.com");
        Observer emailSubscriber2 = new EmailSubscriber("user2@example.com");
        Observer smsSubscriber = new SmsSubscriber("0912345678");

        // Đăng ký các
        notificationSystem.registerObserver(emailSubscriber1);
        notificationSystem.registerObserver(emailSubscriber2);
        notificationSystem.registerObserver(smsSubscriber);

        // Gửi thông báo đầu tiên
        System.out.println("Thông báo 1:");
        notificationSystem.notifyObservers("Hệ thống sẽ bảo trì vào lúc 2h sáng mai");

        // Hủy đăng ký
        notificationSystem.removeObserver(emailSubscriber2);

        System.out.println("\nThông báo 2:");
        notificationSystem.notifyObservers("Bảo trì hoàn tất, hệ thống hoạt động bình thường");
    }
}
