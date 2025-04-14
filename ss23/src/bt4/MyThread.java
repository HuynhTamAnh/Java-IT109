package bt4;

public class MyThread extends Thread {
    private final int threadNumber;

    public MyThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        if (threadNumber == 1) {
            //1 In số từ 1 đến 5, mỗi số cách 1 giây
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread 1: " + i);
                    Thread.sleep(1000); // Dừng 1 giây
                }
            } catch (InterruptedException e) {
                System.out.println("Thread 1 bị gián đoạn");
            }
        } else {
            // 2 và 3 chờ 1 xong gòi chạy
            try {
                System.out.println("Thread " + threadNumber + " đang chờ Thread 1 kết thúc...");
                // Chờ 1 kết thúc
                Thread mainThread = Thread.currentThread();
                for (Thread t : Thread.getAllStackTraces().keySet()) {
                    if (t.getName().equals("Thread-0")) { // Tên mặc định của Thread 1
                        t.join();
                        break;
                    }
                }

                System.out.println("Thread " + threadNumber + " bắt đầu...");
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadNumber + " bị gián đoạn");
            }
        }
    }
}