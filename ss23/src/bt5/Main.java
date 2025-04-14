package bt5;
//Viết chương trình Java mô phỏng việc một người gửi tin nhắn và một người nhận tin nhắn.
//
//Giả sử bạn đang mô phỏng một ứng dụng nhắn tin với hai người:
//
//Người gửi (Writer): Gửi một tin nhắn.
//Người nhận (Reader): Chỉ được xem tin nhắn khi người gửi đã gửi xong.
//	Hãy làm các bước sau:
//
//Tạo một lớp SharedData chứa thuộc tính message kiểu String.
//Tạo hai luồng:
//Writer: gán giá trị cho message và gọi notify().
//Reader: gọi wait() và chỉ được in ra message khi đã được thông báo.
//Sử dụng synchronized, wait() và notify() để đảm bảo đồng bộ giữa hai luồng.
// Lưu ý:
//Dùng đúng kỹ thuật đồng bộ, tránh in ra message trước khi nó được gán giá trị.
//Có thể thêm thời gian sleep() để dễ quan sát quá trình chạy.
public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Thread người gửi
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Giả lập thời gian chuẩn bị tin nhắn
                sharedData.sendMessage("Xin chào!");

                Thread.sleep(2000); // Đợi một lúc trước khi gửi tin nhắn tiếp
                sharedData.sendMessage("Bạn khỏe không?");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread người nhận
        Thread reader = new Thread(() -> {
            sharedData.receiveMessage();

            try {
                Thread.sleep(1500); // Giả lập thời gian xử lý tin nhắn
                sharedData.receiveMessage();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        writer.start();
        reader.start();
    }
}