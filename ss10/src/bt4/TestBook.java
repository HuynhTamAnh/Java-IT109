package bt4;

public class TestBook {
    public static void main(String[] args) {
        Book myBook=new Book("java","tamanh",10000);

        //hiển thị info
        System.out.print("thông tin sách ban đầu: ");
        System.out.println("tên sách: "+myBook.getName());
        System.out.println("tên tác giả: "+myBook.getAuthorName());
        System.out.println("price của sách: "+myBook.getPrice());
        // Thay đổi thông tin thông qua các phương thức setter
        System.out.println("\nThay đổi thông tin sách:");
        myBook.setName("Advanced Java Programming");
        myBook.setAuthorName("Jane Smith");
        myBook.setPrice(45.75);

        // Hiển thị thông tin sau khi thay đổi
        System.out.println("Thông tin sách sau khi thay đổi:");
        System.out.println("Tên sách: " + myBook.getName());
        System.out.println("Tác giả: " + myBook.getAuthorName());
        System.out.println("Giá: $" + myBook.getPrice());

        // Kiểm tra tính hợp lệ của giá sách
        System.out.println("\nKiểm tra tính hợp lệ của giá sách:");
        myBook.setPrice(-10); // Thử đặt giá trị âm
        System.out.println("Giá sách sau khi thử đặt giá trị âm: $" + myBook.getPrice());
    }
}
