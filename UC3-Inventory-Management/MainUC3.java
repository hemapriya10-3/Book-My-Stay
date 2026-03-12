import java.util.Scanner;

public class MainUC3 {
    private static InventoryManagementUC3 inventory;
    private static Scanner scanner;

    public static void main(String[] args) {
        inventory = new InventoryManagementUC3();
        scanner = new Scanner(System.in);
        System.out.println("\n========================================");
        System.out.println("UC3 - INVENTORY MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        managementMenu();

        scanner.close();
    }

    
    private static void managementMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("    INVENTORY MANAGEMENT MENU");
            System.out.println("========================================");
            System.out.println("1. Display All Rooms");
            System.out.println("2. Display Inventory Stats");
            System.out.println("3. Add New Room");
            System.out.println("4. Remove Room by ID");
            System.out.println("5. Update Room Availability");
            System.out.println("6. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice (1-6): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        inventory.displayAllRooms();
                        break;
                    case 2:
                        inventory.displayInventoryStats();
                        break;
                    case 3:
                        addNewRoom();
                        break;
                    case 4:
                        removeRoomByID();
                        break;
                    case 5:
                        updateAvailability();
                        break;
                    case 6:
                        running = false;
                        System.out.println("\n✓ Exiting Inventory Management System...\n");
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

    private static void addNewRoom() {
        System.out.println("\n======= ADD NEW ROOM =======");
        try {
            System.out.print("Enter Room ID: ");
            int roomId = scanner.nextInt();

            System.out.print("Enter Room Type (Single Room/Double Room/Deluxe Room/Suite): ");
            scanner.nextLine();
            String roomType = scanner.nextLine();

            System.out.print("Enter Price per Night: Rs. ");
            double price = scanner.nextDouble();

            System.out.print("Is room available? (true/false): ");
            boolean availability = scanner.nextBoolean();

            RoomUC3 newRoom = new RoomUC3(roomId, roomType, price, availability);
            inventory.addRoom(newRoom);
        } catch (Exception e) {
            System.out.println("Error adding room! Please check your input.");
            scanner.nextLine();
        }
    }

    private static void removeRoomByID() {
        System.out.println("\n======= REMOVE ROOM =======");
        try {
            System.out.print("Enter Room ID to remove: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();

            inventory.removeRoom(roomId);
        } catch (Exception e) {
            System.out.println("Error removing room! Please check your input.");
            scanner.nextLine();
        }
    }
    private static void updateAvailability() {
        System.out.println("\n======= UPDATE AVAILABILITY =======");
        try {
            System.out.print("Enter Room ID: ");
            int roomId = scanner.nextInt();

            System.out.print("Is available? (true/false): ");
            boolean isAvailable = scanner.nextBoolean();

            inventory.updateRoomAvailability(roomId, isAvailable);
        } catch (Exception e) {
            System.out.println("Error updating availability! Please check your input.");
            scanner.nextLine();
        }
    }
}
