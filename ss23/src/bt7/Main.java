package bt7;
//Viết chương trình Java gồm 2 luồng:
//
//Thread 1 (Producer): Sinh ra các số trong dãy Fibonacci, lưu vào biến dùng chung (sharedValue).
//Thread 2 (Consumer): Nhận từng giá trị Fibonacci từ Thread 1 và in ra màn hình.
//
//
//Ràng buộc:
//Sử dụng wait() và notify() để đảm bảo:
//Thread 2 chỉ in số khi có số mới khi Thread 1 đã sinh ra số.
//Thread 1 chỉ sinh số mới khi Thread 2 đã in xong số trước đó.
//
//
//Yêu cầu thêm:
//In ra 10 số Fibonacci đầu tiên là đủ.
public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread producer = new Thread(new FibonacciProducer(sharedData), "Producer");
        Thread consumer = new Thread(new FibonacciConsumer(sharedData), "Consumer");

        producer.start();
        consumer.start();
    }
}
