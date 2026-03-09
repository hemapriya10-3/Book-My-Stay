import java.util.Scanner;

/**
 * UC1 - Application Entry & Welcome Message
 * This class demonstrates User Case 1:
 * When the application starts, display a welcome screen with main menu options
 */
public class MainUC1 {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        // Display welcome screen
        displayWelcomeScreen();
        
        // Display main menu
        mainMenu();
        
        scanner.close();
    }

    /**
     * UC1 - Display welcome screen when application starts
     */
    private static void displayWelcomeScreen() {
        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("   WELCOME TO HOSTEL BOOKING SYSTEM");
        System.out.println("========================================");
        System.out.println("Your trusted platform for affordable accommodation!\n");
    }

    /**
     * UC1 - Main menu with 4 options as specified:
     * 1. View Room Types
     * 2. Search Available Rooms
     * 3. Book a Room
     * 4. Exit
     */
    private static void mainMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n========================================");
            System.out.println("           MAIN MENU");
            System.out.println("========================================");
            System.out.println("1. View Room Types");
            System.out.println("2. Search Available Rooms");
            System.out.println("3. Book a Room");
            System.out.println("4. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice (1-4): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("\n→ View Room Types feature will be implemented in UC2");
                        break;
                    case 2:
                        System.out.println("\n→ Search Available Rooms feature will be implemented in UC4");
                        break;
                    case 3:
                        System.out.println("\n→ Book a Room feature will be implemented in UC5");
                        break;
                    case 4:
                        exitApplication();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    /**
     * Exit application gracefully
     */
    private static void exitApplication() {
        System.out.println("\n========================================");
        System.out.println("   Thank you for using our system!");
        System.out.println("     Safe travels and happy stays!");
        System.out.println("========================================\n");
    }
}
