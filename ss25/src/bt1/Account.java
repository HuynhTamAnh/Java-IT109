package bt1;

public class Account {
    // Các thuộc tính của Account
    private int id;
    private String name;
    private int age;

    private static Account instance;

    // Constructor private
    private Account() {
        // Khởi tạo mặc định
        this.id = 0;
        this.name = "";
        this.age = 0;
    }

    public static Account getInstance() {
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
