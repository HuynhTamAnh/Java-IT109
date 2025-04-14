package bt4;
//Viết một chương trình gồm 3 Thread:
//
//Thread 1 in ra các số từ 1 đến 5 với mỗi số cách nhau 1 giây (dùng Thread.sleep())
//Thread 2 và Thread 3 không bắt đầu cho đến khi Thread 1 kết thúc (dùng join())
//Bạn có thể cho Thread 2 và 3 in ra một đoạn văn bản đơn giản, ví dụ: "Thread 2 bắt đầu...", "Thread 3 bắt đầu...".
//	Gợi ý:
//
//Tạo lớp MyThread kế thừa Thread hoặc implement Runnable.
//Dùng thread1.join() trong Thread 2 và 3 để đảm bảo đúng thứ tự
public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);
        MyThread thread3 = new MyThread(3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}