import java.util.ArrayList;

/**
 * UC2 - Basic Room Types & Static Availability
 * This use case demonstrates:
 * 1. Define different room types (Single, Double, Deluxe, Suite)
 * 2. Each room has: Room ID, Type, Price, Availability status
 * 3. Store initial room data statically in the program
 */
public class MainUC2 {
    private static ArrayList<RoomUC2> rooms;

    public static void main(String[] args) {
        // Initialize room data statically
        initializeRooms();
        
        // Display room types and prices
        displayRoomTypes();
        
        // Display all rooms with their details
        displayAllRooms();
    }

    /**
     * UC2 - Initialize rooms with static data
     * Define 4 room types with their properties:
     * - Room ID
     * - Room Type (Single, Double, Deluxe, Suite)
     * - Price per night
     * - Availability status
     */
    private static void initializeRooms() {
        rooms = new ArrayList<>();

        // Single Rooms (Price: Rs. 1500)
        rooms.add(new RoomUC2(101, "Single Room", 1500, true));
        rooms.add(new RoomUC2(102, "Single Room", 1500, true));
        rooms.add(new RoomUC2(103, "Single Room", 1500, false));

        // Double Rooms (Price: Rs. 2500)
        rooms.add(new RoomUC2(201, "Double Room", 2500, true));
        rooms.add(new RoomUC2(202, "Double Room", 2500, true));
        rooms.add(new RoomUC2(203, "Double Room", 2500, false));

        // Deluxe Rooms (Price: Rs. 4000)
        rooms.add(new RoomUC2(301, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC2(302, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC2(303, "Deluxe Room", 4000, false));

        // Suites (Price: Rs. 6000)
        rooms.add(new RoomUC2(401, "Suite", 6000, true));
        rooms.add(new RoomUC2(402, "Suite", 6000, false));
        rooms.add(new RoomUC2(403, "Suite", 6000, true));

        System.out.println("✓ Room data initialized successfully!");
        System.out.println("✓ Total rooms in inventory: " + rooms.size());
    }

    /**
     * UC2 - Display all room types with their prices
     */
    private static void displayRoomTypes() {
        System.out.println("\n========================================");
        System.out.println("        AVAILABLE ROOM TYPES");
        System.out.println("========================================");
        System.out.println("1. Single Room      - Rs. 1500 per night");
        System.out.println("2. Double Room      - Rs. 2500 per night");
        System.out.println("3. Deluxe Room      - Rs. 4000 per night");
        System.out.println("4. Suite            - Rs. 6000 per night");
        System.out.println("========================================\n");
    }

    /**
     * UC2 - Display all rooms with their complete details
     * Shows: Room ID, Type, Price, and Availability
     */
    private static void displayAllRooms() {
        System.out.println("\n========================================");
        System.out.println("   ALL ROOMS WITH STATIC DATA");
        System.out.println("========================================");
        
        for (RoomUC2 room : rooms) {
            room.displayDetails();
        }

        // Summary statistics
        System.out.println("\nRoom Type Summary:");
        System.out.println("├─ Single Rooms: 3 rooms (IDs: 101, 102, 103)");
        System.out.println("├─ Double Rooms: 3 rooms (IDs: 201, 202, 203)");
        System.out.println("├─ Deluxe Rooms: 3 rooms (IDs: 301, 302, 303)");
        System.out.println("└─ Suites: 3 rooms (IDs: 401, 402, 403)");
    }
}
