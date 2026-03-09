import java.util.ArrayList;
import java.util.Iterator;

/**
 * UC3 - Centralized Room Inventory Management
 * This class maintains a centralized data structure (ArrayList) to manage all rooms.
 * Provides methods to:
 * - Add rooms
 * - Remove rooms
 * - Update room availability
 * - Display all rooms
 */
public class InventoryManagementUC3 {
    private ArrayList<RoomUC3> rooms;

    // Constructor
    public InventoryManagementUC3() {
        this.rooms = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Initialize rooms with static data
     */
    private void initializeRooms() {
        // Single Rooms
        rooms.add(new RoomUC3(101, "Single Room", 1500, true));
        rooms.add(new RoomUC3(102, "Single Room", 1500, true));
        rooms.add(new RoomUC3(103, "Single Room", 1500, false));

        // Double Rooms
        rooms.add(new RoomUC3(201, "Double Room", 2500, true));
        rooms.add(new RoomUC3(202, "Double Room", 2500, true));
        rooms.add(new RoomUC3(203, "Double Room", 2500, false));

        // Deluxe Rooms
        rooms.add(new RoomUC3(301, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC3(302, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC3(303, "Deluxe Room", 4000, false));

        // Suites
        rooms.add(new RoomUC3(401, "Suite", 6000, true));
        rooms.add(new RoomUC3(402, "Suite", 6000, false));
        rooms.add(new RoomUC3(403, "Suite", 6000, true));
    }

    /**
     * UC3 - Add a new room to inventory
     */
    public void addRoom(RoomUC3 room) {
        rooms.add(room);
        System.out.println("✓ Room " + room.getRoomId() + " added successfully!");
        System.out.println("  Room Type: " + room.getRoomType());
        System.out.println("  Price: Rs. " + room.getPrice());
    }

    /**
     * UC3 - Remove a room from inventory by Room ID
     */
    public void removeRoom(int roomId) {
        Iterator<RoomUC3> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            RoomUC3 room = iterator.next();
            if (room.getRoomId() == roomId) {
                String roomType = room.getRoomType();
                iterator.remove();
                System.out.println("✓ Room " + roomId + " (" + roomType + ") removed successfully!");
                return;
            }
        }
        System.out.println("✗ Room " + roomId + " not found in inventory!");
    }

    /**
     * UC3 - Update room availability status
     */
    public void updateRoomAvailability(int roomId, boolean isAvailable) {
        for (RoomUC3 room : rooms) {
            if (room.getRoomId() == roomId) {
                room.setAvailability(isAvailable);
                String status = isAvailable ? "Available" : "Not Available";
                System.out.println("✓ Room " + roomId + " availability updated to: " + status);
                return;
            }
        }
        System.out.println("✗ Room " + roomId + " not found in inventory!");
    }

    /**
     * UC3 - Display all rooms in inventory
     */
    public void displayAllRooms() {
        System.out.println("\n========================================");
        System.out.println("     CENTRALIZED ROOM INVENTORY");
        System.out.println("========================================");
        System.out.println("Total Rooms: " + rooms.size());
        System.out.println("----------------------------------------");

        if (rooms.isEmpty()) {
            System.out.println("No rooms in inventory!");
            return;
        }

        // Display rooms grouped by type
        displayRoomsByType("Single Room");
        displayRoomsByType("Double Room");
        displayRoomsByType("Deluxe Room");
        displayRoomsByType("Suite");
    }

    /**
     * Helper method to display rooms of specific type
     */
    private void displayRoomsByType(String roomType) {
        System.out.println("\n" + roomType.toUpperCase() + ":");
        boolean found = false;
        for (RoomUC3 room : rooms) {
            if (room.getRoomType().equals(roomType)) {
                System.out.println("  ID: " + room.getRoomId() + 
                                 " | Price: Rs. " + room.getPrice() + 
                                 " | Status: " + (room.isAvailable() ? "Available" : "Not Available"));
                found = true;
            }
        }
        if (!found) {
            System.out.println("  (No rooms of this type)");
        }
    }

    /**
     * Get room by ID
     */
    public RoomUC3 getRoomById(int roomId) {
        for (RoomUC3 room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    /**
     * Get total number of rooms
     */
    public int getTotalRooms() {
        return rooms.size();
    }

    /**
     * Get available rooms count
     */
    public int getAvailableRoomsCount() {
        int count = 0;
        for (RoomUC3 room : rooms) {
            if (room.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get unavailable rooms count
     */
    public int getUnavailableRoomsCount() {
        return getTotalRooms() - getAvailableRoomsCount();
    }

    /**
     * Display inventory statistics
     */
    public void displayInventoryStats() {
        System.out.println("\n========================================");
        System.out.println("     INVENTORY STATISTICS");
        System.out.println("========================================");
        System.out.println("Total Rooms:        " + getTotalRooms());
        System.out.println("Available Rooms:    " + getAvailableRoomsCount());
        System.out.println("Unavailable Rooms:  " + getUnavailableRoomsCount());
        System.out.println("Occupancy Rate:     " + String.format("%.2f%%", 
            (getUnavailableRoomsCount() * 100.0 / getTotalRooms())));
        System.out.println("========================================\n");
    }

    /**
     * Get all rooms list
     */
    public ArrayList<RoomUC3> getAllRooms() {
        return rooms;
    }
}
