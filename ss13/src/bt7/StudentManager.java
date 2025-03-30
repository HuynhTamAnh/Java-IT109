package bt7;

public class StudentManager {
    public static void main(String[] args) {
        StudentUI ui = new StudentUI();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        boolean running = true;
        while (running) {
            ui.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    ui.processAddStudent();
                    break;
                case 2:
                    ui.displayAllStudents();
                    break;
                case 3:
                    ui.searchStudents();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    ui.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}