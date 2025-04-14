package bt3;
//Viết chương trình Java thực hiện các bước sau đây:
//
//Tạo lớp SharedResource với một phương thức có tên printAlphabet(), nhiệm vụ là in ra màn hình lần lượt các ký tự từ 'A' đến 'Z'.
//Tạo hai luồng (threads), cùng sử dụng chung một đối tượng SharedResource để gọi phương thức printAlphabet().
//Sử dụng từ khóa synchronized để đảm bảo hai luồng không in đan xen vào nhau, mà mỗi luồng sẽ in toàn bộ dãy chữ cái từ 'A' đến 'Z' hoàn chỉnh trước khi luồng khác bắt đầu.
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng SharedResource dùng chung
        SharedResource sharedResource = new SharedResource();

        // Tạo và khởi chạy thread 1
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 bắt đầu:");
            sharedResource.printAlphabet();
        });

        // Tạo và khởi chạy thread 2
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 bắt đầu:");
            sharedResource.printAlphabet();
        });

        // Khởi chạy các thread
        thread1.start();
        thread2.start();
    }
}