package bt6;

public class MoveablePoint extends Point {
    // Thuộc tính xSpeed và ySpeed
    private double xSpeed;
    private double ySpeed;

    // Constructor không tham số
    public MoveablePoint() {
        super();
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    // Constructor với tham số x, y
    public MoveablePoint(double x, double y) {
        super(x, y);
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    // Constructor với tham số x, y, xSpeed, ySpeed
    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Getter và setter cho thuộc tính xSpeed
    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    // Getter và setter cho thuộc tính ySpeed
    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    // Phương thức để set cả xSpeed và ySpeed cùng lúc
    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Phương thức move(): Cập nhật tọa độ của điểm theo tốc độ
    public MoveablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }

    // Phương thức toString(): Trả về thông tin của điểm với tốc độ
    @Override
    public String toString() {
        return super.toString() + ", speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}