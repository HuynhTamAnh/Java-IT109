package bt1;
//Hãy triển khai mẫu thiết kế Singleton để đảm bảo rằng một lớp chỉ có một thể hiện duy nhất trong toàn bộ chương trình.
public class Main {
    public static void main(String[] args) {

        Account account1 = Account.getInstance();
        Account account2 = Account.getInstance();
        Account account3 = Account.getInstance();

        account1.setId(1);
        account1.setName("John Doe");
        account1.setAge(30);

        System.out.println("Account 1: " + account1.getId() + " - " + account1.getName() + " - " + account1.getAge());
        System.out.println("Account 2: " + account2.getId() + " - " + account2.getName() + " - " + account2.getAge());
        System.out.println("Account 3: " + account3.getId() + " - " + account3.getName() + " - " + account3.getAge());

        // Kiểm tra xem có phải cùng một đối tượng không
        System.out.println("account1 == account2: " + (account1 == account2));
        System.out.println("account2 == account3: " + (account2 == account3));
    }
}
