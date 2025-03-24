package bt6;

public class TestMoveablePoint {
    public static void main(String[] args) {
        // Tạo đối tượng Point
        Point p1 = new Point(1.0, 2.0);
        System.out.println("Point: " + p1.toString());

        // Tạo đối tượng MoveablePoint
        MoveablePoint mp1 = new MoveablePoint(3.0, 4.0, 0.5, 0.5);
        System.out.println("MoveablePoint trước khi di chuyển: " + mp1.toString());

        // Di chuyển điểm
        mp1.move();
        System.out.println("MoveablePoint sau khi di chuyển: " + mp1.toString());

        // Kiểm tra thay đổi tọa độ bằng setter
        mp1.setXSpeed(1.0);
        mp1.setYSpeed(2.0);
        System.out.println("MoveablePoint sau khi thay đổi tốc độ: " + mp1.toString());

        // Di chuyển lần nữa
        mp1.move();
        System.out.println("MoveablePoint sau khi di chuyển lần 2: " + mp1.toString());

        // Thử nghiệm với nhiều cách khởi tạo khác nhau
        MoveablePoint mp2 = new MoveablePoint();
        System.out.println("MoveablePoint mặc định: " + mp2.toString());

        MoveablePoint mp3 = new MoveablePoint(5.0, 5.0);
        mp3.setSpeed(1.5, 2.5);
        System.out.println("MoveablePoint với tốc độ mới: " + mp3.toString());
        mp3.move();
        System.out.println("MoveablePoint sau khi di chuyển: " + mp3.toString());
    }
}