package bt1;
//Viết một chương trình tạo một lớp kế thừa Thread. Trong phương thức run(), in ra dòng chữ:
//
// "Thread đang chạy: [Tên thread]"
//
//
//Yêu cầu:
//
//Tạo hai đối tượng thread và khởi chạy chúng
public class Main {
    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
