package bt4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo danh sách các thiết bị
        List<Electronic> devices = new ArrayList<>();

        // Thêm TV và Radio vào danh sách
        devices.add(new TV());
        devices.add(new Radio());

        // Duyệt qua danh sách và gọi các phương thức
        for (Electronic device : devices) {
            device.turnOn();
            device.turnOff();
        }
    }
}