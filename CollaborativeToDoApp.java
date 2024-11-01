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
        closeResources();
    }

    private static void runApp() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> assignTask();
                case 4 -> viewAnalytics();
                case 5 -> running = confirmLogout();
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

    private static void addTask() {
        taskManager.addTask();
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        taskManager.viewTasks();
    }

    private static void assignTask() {
        collaborationManager.assignTask(userManager.getCurrentUser());
        System.out.println("Task assigned successfully.");
    }

    private static void viewAnalytics() {
        analytics.showReport();
        System.out.println("Analytics displayed.");
    }

    private static boolean confirmLogout() {
        while (true) {
            System.out.print("Are you sure you want to logout? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                System.out.println("Logging out... Goodbye!");
                return false;  // Exit runApp loop
            } else if (response.equals("n")) {
                return true;  // Continue running the app
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    private static void closeResources() {
        scanner.close();
        System.out.println("Resources closed.");
    }
}
