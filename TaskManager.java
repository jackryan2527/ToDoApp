import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task task = new Task(description, priority);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        System.out.println("\n--- Tasks ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

class Task {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        String priorityStr = switch (priority) {
            case 1 -> "High";
            case 2 -> "Medium";
            case 3 -> "Low";
            default -> "Unknown";
        };
        return "Task: " + description + " | Priority: " + priorityStr;
    }
}
