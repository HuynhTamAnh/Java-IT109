package bt3;
//Viết một chương trình gửi thông báo. Module cấp cao chỉ phụ thuộc vào interface Notification, không phụ thuộc vào chi tiết lớp gửi thông báo như EmailNotification hay SMSNotification.
//
//
//
//Yêu cầu:
//
//Tạo interface Notification
//Có phương thức send(String message) thông báo đã gửi nội dung + message
//Triển khai các lớp EmailNotification, SMSNotification
//Module cấp cao sử dụng dependency injection
//Viết lớp Main kiểm thử các chức năng đã làm
public class Main {
    public static void main(String[] args) {

        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();

        NotificationService emailService = new NotificationService(emailNotification);
        emailService.sendNotification("Hello via Email!");

        NotificationService smsService = new NotificationService(smsNotification);
        smsService.sendNotification("Hello via SMS!");

    }
}