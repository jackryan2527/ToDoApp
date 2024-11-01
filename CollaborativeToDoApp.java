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
            System.out.println("Logged in as: " + userManager.getCurrentUser());
            runApp();
        } else {
            System.out.println("Failed to login. Exiting...");
        }
    }

    private static void runApp() {
        boolean running = true;
        while (running) {
            displayMenu();

            int choice = getUserChoice();
            switch (choice) {
                case 1 -> taskManager.addTask();
                case 2 -> taskManager.viewTasks();
                case 3 -> collaborationManager.assignTask(userManager.getCurrentUser());
                case 4 -> analytics.showReport();
                case 5 -> {
                    if (confirmLogout()) {
                        running = false;
                        System.out.println("Logging out... Goodbye!");
                    }
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Assign Task");
        System.out.println("4. View Analytics");
        System.out.println("5. Logout");
    }

    private static int getUserChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Please choose a valid option (1-5).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static boolean confirmLogout() {
        System.out.print("Are you sure you want to logout? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }
}
