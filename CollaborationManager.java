import java.util.Scanner;

public class CollaborationManager {
    private Scanner scanner = new Scanner(System.in);

    public void assignTask(String user) {
        System.out.print("Enter task description to assign: ");
        String taskDesc = scanner.nextLine();
        System.out.print("Enter username to assign the task to: ");
        String assignedUser = scanner.nextLine();

        // In a full app, we'd find the Task object by description and update its assigned user
        System.out.println("Task \"" + taskDesc + "\" assigned to " + assignedUser + " by " + user + ".");
    }
}
