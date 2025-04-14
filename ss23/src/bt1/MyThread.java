package bt1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread đang chạy: " + this.getName());
    }
}
