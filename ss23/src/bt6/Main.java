package bt6;
//Tạo 3 luồng với các mức độ ưu tiên khác nhau:
//
//Thread 1 có ưu tiên thấp nhất (MIN_PRIORITY)
//Thread 2 có ưu tiên trung bình (NORM_PRIORITY)
//Thread 3 có ưu tiên cao nhất (MAX_PRIORITY)
//
//
//Yêu cầu:
//
//In ra thông báo từ các luồng và quan sát cách hệ thống xử lý các mức ưu tiên
//Trả lời câu hỏi sau: Liệu mức độ ưu tiên (priority) của các luồng có đảm bảo 100% thứ tự thực hiện giữa chúng không? Giải thích tại sao.
public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task(), "Thread 1 (MIN_PRIORITY)");
        Thread thread2 = new Thread(new Task(), "Thread 2 (NORM_PRIORITY)");
        Thread thread3 = new Thread(new Task(), "Thread 3 (MAX_PRIORITY)");

        // Thiết lập mức độ ưu tiên
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Lần " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
