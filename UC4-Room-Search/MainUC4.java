import java.util.ArrayList;
import java.util.Scanner;

/**
 * UC4 - Room Search & Availability Check
 * Demonstrates search functionality:
 * - Search rooms based on room type
 * - Search available rooms
 * - Display available rooms with their details
 * - Check availability of specific room
 */
public class MainUC4 {
    private static SearchManagementUC4 searchManagement;
    private static Scanner scanner;

    public static void main(String[] args) {
        searchManagement = new SearchManagementUC4();
        scanner = new Scanner(System.in);

        System.out.println("\n========================================");
        System.out.println("UC4 - ROOM SEARCH & AVAILABILITY");
        System.out.println("========================================\n");

        searchMenu();

        scanner.close();
    }

    /**
     * Interactive search menu
     */
    private static void searchMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("        ROOM SEARCH MENU");
            System.out.println("========================================");
            System.out.println("1. View All Room Types");
            System.out.println("2. View All Available Rooms");
            System.out.println("3. Search Available Rooms by Type");
            System.out.println("4. Check Specific Room Availability");
            System.out.println("5. View Search Statistics");
            System.out.println("6. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice (1-6): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        searchManagement.displayAllRoomTypes();
                        break;
                    case 2:
                        searchManagement.displayAllAvailableRooms();
                        break;
                    case 3:
                        searchByType();
                        break;
                    case 4:
                        checkAvailability();
                        break;
                    case 5:
                        searchManagement.displaySearchStats();
                        break;
                    case 6:
                        running = false;
                        System.out.println("\n✓ Exiting Search System...\n");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1-6.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    /**
     * UC4 - Search available rooms by type
     */
    private static void searchByType() {
        System.out.println("\n========================================");
        System.out.println("    SELECT ROOM TYPE");
        System.out.println("========================================");
        System.out.println("1. Single Room");
        System.out.println("2. Double Room");
        System.out.println("3. Deluxe Room");
        System.out.println("4. Suite");
        System.out.println("========================================");
        System.out.print("Enter room type choice (1-4): ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            String roomType = "";
            switch (choice) {
                case 1:
                    roomType = "Single Room";
                    break;
                case 2:
                    roomType = "Double Room";
                    break;
                case 3:
                    roomType = "Deluxe Room";
                    break;
                case 4:
                    roomType = "Suite";
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            // Display available rooms of selected type
            searchManagement.displayAvailableRoomsByType(roomType);

            // Also show all rooms of that type (available and unavailable)
            ArrayList<RoomUC4> allRoomsOfType = searchManagement.searchByRoomType(roomType);
            System.out.println("All " + roomType + "s in Inventory (" + allRoomsOfType.size() + " total):");
            for (RoomUC4 room : allRoomsOfType) {
                room.displaySearchResult();
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
            scanner.nextLine();
        }
    }

    /**
     * UC4 - Check availability of specific room by ID
     */
    private static void checkAvailability() {
        System.out.println("\n========================================");
        System.out.println("    CHECK ROOM AVAILABILITY");
        System.out.println("========================================");

        try {
            System.out.print("Enter Room ID to check: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();

            RoomUC4 room = searchManagement.getRoomById(roomId);

            if (room == null) {
                System.out.println("\n✗ Room " + roomId + " not found!");
            } else {
                System.out.println("\n--- Room Details ---");
                System.out.println("Room ID: " + room.getRoomId());
                System.out.println("Room Type: " + room.getRoomType());
                System.out.println("Price: Rs. " + room.getPrice() + " per night");
                System.out.println("Status: " + (room.isAvailable() ? "✓ AVAILABLE" : "✗ NOT AVAILABLE"));

                if (room.isAvailable()) {
                    System.out.println("\n✓ This room is available for booking!");
                } else {
                    System.out.println("\n✗ This room is already booked.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid room ID.");
            scanner.nextLine();
        }
    }
}
