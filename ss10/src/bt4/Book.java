package bt4;

public class Book {
    private String name;
    private String authorName;
    private double price;

    public Book(String name, String authorName, double price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }else{
            System.out.println("Lỗi: Giá sách không được âm!");
        }
    }





}
