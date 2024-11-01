import java.util.HashMap;
import java.util.Scanner;

public class UserManager {
    private HashMap<String, String> users = new HashMap<>(); // username, password
    private String currentUser;

    public UserManager() {
        // Add some users for demo purposes
        users.put("admin", "admin123");
        users.put("user1", "pass1");
        users.put("user2", "pass2");
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
