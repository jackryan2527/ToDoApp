import java.util.Scanner;

public class CollaborativeToDoApp {
    private static UserManager userManager = new UserManager();
    private static TaskManager taskManager = new TaskManager();
    private static CollaborationManager collaborationManager = new CollaborationManager();
    private static Analytics analytics = new Analytics();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Collaborative To-Do Management System!");

        if (userManager.login()) {
            runApp();
        } else {
            System.out.println("Failed to login. Exiting...");
        }
    }

    private static void runApp() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Assign Task");
            System.out.println("4. View Analytics");
            System.out.println("5. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> taskManager.addTask();
                case 2 -> taskManager.viewTasks();
                case 3 -> collaborationManager.assignTask(userManager.getCurrentUser());
                case 4 -> analytics.showReport();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
