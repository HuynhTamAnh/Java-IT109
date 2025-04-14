package bt2;
//Tạo một lớp triển khai (implements) interface Runnable.
//Bên trong phương thức run() của lớp này, thực hiện in ra màn hình các số nguyên từ 1 đến 10 (mỗi số trên một dòng).
//Trong phương thức main, tạo một đối tượng từ lớp đã triển khai Runnable, rồi khởi chạy nó bằng cách sử dụng lớp Thread.


public class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
