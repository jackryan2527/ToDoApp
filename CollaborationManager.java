import java.util.Scanner;

public class CollaborationManager {
    private final Scanner scanner = new Scanner(System.in);

    public void assignTask(String user) {
        String taskDesc = getTaskDescription();
        String assignedUser = getAssignedUser();

        // In a full app, we'd find the Task object by description and update its assigned user
        // For now, we simply output the assignment.
        System.out.println("Task \"" + taskDesc + "\" assigned to " + assignedUser + " by " + user + ".");
    }

    private String getTaskDescription() {
        System.out.print("Enter task description to assign: ");
        String taskDesc = scanner.nextLine().trim();
        while (taskDesc.isEmpty()) {
            System.out.println("Task description cannot be empty. Please try again.");
            System.out.print("Enter task description to assign: ");
            taskDesc = scanner.nextLine().trim();
        }
        return taskDesc;
    }

    private String getAssignedUser() {
        System.out.print("Enter username to assign the task to: ");
        String assignedUser = scanner.nextLine().trim();
        while (assignedUser.isEmpty()) {
            System.out.println("Username cannot be empty. Please try again.");
            System.out.print("Enter username to assign the task to: ");
            assignedUser = scanner.nextLine().trim();
        }
        return assignedUser;
    }

    public void closeScanner() {
        scanner.close();
    }
}
