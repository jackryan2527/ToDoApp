import java.util.Random;

public class Analytics {
    public void showReport() {
        Random random = new Random();
        int completedTasks = random.nextInt(20);
        int pendingTasks = random.nextInt(20);

        System.out.println("\n--- Analytics Report ---");
        System.out.println("Total Tasks: " + (completedTasks + pendingTasks));
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Pending Tasks: " + pendingTasks);
        System.out.println("High Priority Tasks: " + random.nextInt(10));
    }
}
