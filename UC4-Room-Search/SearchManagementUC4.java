import java.util.ArrayList;

/**
 * UC4 - Room Search & Availability Check
 * Provides search functionality based on:
 * - Room type
 * - Availability
 */
public class SearchManagementUC4 {
    private ArrayList<RoomUC4> rooms;

    public SearchManagementUC4() {
        this.rooms = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Initialize rooms with static data
     */
    private void initializeRooms() {
        // Single Rooms
        rooms.add(new RoomUC4(101, "Single Room", 1500, true));
        rooms.add(new RoomUC4(102, "Single Room", 1500, true));
        rooms.add(new RoomUC4(103, "Single Room", 1500, false));

        // Double Rooms
        rooms.add(new RoomUC4(201, "Double Room", 2500, true));
        rooms.add(new RoomUC4(202, "Double Room", 2500, true));
        rooms.add(new RoomUC4(203, "Double Room", 2500, false));

        // Deluxe Rooms
        rooms.add(new RoomUC4(301, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC4(302, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC4(303, "Deluxe Room", 4000, false));

        // Suites
        rooms.add(new RoomUC4(401, "Suite", 6000, true));
        rooms.add(new RoomUC4(402, "Suite", 6000, false));
        rooms.add(new RoomUC4(403, "Suite", 6000, true));
    }

    /**
     * UC4 - Display all room types available
     */
    public void displayAllRoomTypes() {
        System.out.println("\n========================================");
        System.out.println("        AVAILABLE ROOM TYPES");
        System.out.println("========================================");
        
        ArrayList<String> roomTypes = new ArrayList<>();
        for (RoomUC4 room : rooms) {
            if (!roomTypes.contains(room.getRoomType())) {
                roomTypes.add(room.getRoomType());
            }
        }

        int count = 1;
        for (String type : roomTypes) {
            RoomUC4 sample = rooms.stream()
                .filter(r -> r.getRoomType().equals(type))
                .findFirst()
                .orElse(null);
            if (sample != null) {
                System.out.println(count + ". " + type + " - Rs. " + sample.getPrice() + " per night");
            }
            count++;
        }
        System.out.println("========================================\n");
    }

    /**
     * UC4 - Search rooms by room type
     * Returns ArrayList of all rooms matching the type
     */
    public ArrayList<RoomUC4> searchByRoomType(String roomType) {
        ArrayList<RoomUC4> searchResults = new ArrayList<>();
        for (RoomUC4 room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType)) {
                searchResults.add(room);
            }
        }
        return searchResults;
    }

    /**
     * UC4 - Search available rooms by type
     * Returns ArrayList of rooms that match type AND are available
     */
    public ArrayList<RoomUC4> searchAvailableRoomsByType(String roomType) {
        ArrayList<RoomUC4> availableRooms = new ArrayList<>();
        for (RoomUC4 room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * UC4 - Display all available rooms
     */
    public void displayAllAvailableRooms() {
        System.out.println("\n========================================");
        System.out.println("        ALL AVAILABLE ROOMS");
        System.out.println("========================================");

        ArrayList<RoomUC4> availableRooms = new ArrayList<>();
        for (RoomUC4 room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }

        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms at the moment!");
            System.out.println("========================================\n");
            return;
        }

        System.out.println("Total Available: " + availableRooms.size() + "\n");
        for (RoomUC4 room : availableRooms) {
            room.displaySearchResult();
        }
        System.out.println("========================================\n");
    }

    /**
     * UC4 - Display available rooms by specific type with details
     */
    public void displayAvailableRoomsByType(String roomType) {
        ArrayList<RoomUC4> availableRooms = searchAvailableRoomsByType(roomType);

        System.out.println("\n========================================");
        System.out.println("    AVAILABLE " + roomType.toUpperCase() + "S");
        System.out.println("========================================");

        if (availableRooms.isEmpty()) {
            System.out.println("✗ No available " + roomType + " at the moment!");
            System.out.println("========================================\n");
            return;
        }

        System.out.println("Found: " + availableRooms.size() + " available\n");
        for (RoomUC4 room : availableRooms) {
            room.displaySearchResult();
        }
        System.out.println("========================================\n");
    }

    /**
     * UC4 - Check if specific room is available
     */
    public boolean isRoomAvailable(int roomId) {
        for (RoomUC4 room : rooms) {
            if (room.getRoomId() == roomId) {
                return room.isAvailable();
            }
        }
        return false;
    }

    /**
     * UC4 - Get room by ID
     */
    public RoomUC4 getRoomById(int roomId) {
        for (RoomUC4 room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    /**
     * Get total available rooms count
     */
    public int getAvailableRoomsCount() {
        int count = 0;
        for (RoomUC4 room : rooms) {
            if (room.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Display search statistics
     */
    public void displaySearchStats() {
        System.out.println("\n========================================");
        System.out.println("        SEARCH STATISTICS");
        System.out.println("========================================");
        System.out.println("Total Rooms: " + rooms.size());
        System.out.println("Available Rooms: " + getAvailableRoomsCount());
        System.out.println("Booked Rooms: " + (rooms.size() - getAvailableRoomsCount()));
        System.out.println("Availability Rate: " + String.format("%.1f%%", 
            (getAvailableRoomsCount() * 100.0 / rooms.size())));
        System.out.println("========================================\n");
    }

    /**
     * Get all rooms
     */
    public ArrayList<RoomUC4> getAllRooms() {
        return rooms;
    }
}
