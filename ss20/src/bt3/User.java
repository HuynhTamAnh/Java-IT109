package bt3;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phoneNumber;


    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }


    public void printInfo() {
        System.out.println("Tên: " + name + ", SĐT: " +
                phoneNumber.orElse("Không có"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }
}