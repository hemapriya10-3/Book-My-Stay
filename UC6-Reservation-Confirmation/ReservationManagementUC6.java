import java.util.ArrayList;

/**
 * UC6 - Reservation Management for Reservation Confirmation & Room Allocation
 * Confirms bookings and allocates rooms to customers
 */
public class ReservationManagementUC6 {
    private ArrayList<RoomUC6> rooms;
    private ArrayList<ReservationUC6> confirmedReservations;

    public ReservationManagementUC6() {
        this.rooms = new ArrayList<>();
        this.confirmedReservations = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Initialize rooms with static data
     */
    private void initializeRooms() {
        // Single Rooms
        rooms.add(new RoomUC6(101, "Single Room", 1500, true));
        rooms.add(new RoomUC6(102, "Single Room", 1500, true));
        rooms.add(new RoomUC6(103, "Single Room", 1500, false));

        // Double Rooms
        rooms.add(new RoomUC6(201, "Double Room", 2500, true));
        rooms.add(new RoomUC6(202, "Double Room", 2500, true));
        rooms.add(new RoomUC6(203, "Double Room", 2500, false));

        // Deluxe Rooms
        rooms.add(new RoomUC6(301, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC6(302, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC6(303, "Deluxe Room", 4000, false));

        // Suites
        rooms.add(new RoomUC6(401, "Suite", 6000, true));
        rooms.add(new RoomUC6(402, "Suite", 6000, false));
        rooms.add(new RoomUC6(403, "Suite", 6000, true));
    }

    /**
     * UC6 - Confirm reservation and allocate room
     * If room is available, confirm and mark as unavailable
     */
    public ReservationUC6 confirmReservation(String customerName, int roomId, 
                                             String checkInDate, String checkOutDate) {
        // Find room
        RoomUC6 room = getRoomById(roomId);

        // Verify room exists
        if (room == null) {
            System.out.println("✗ Room " + roomId + " not found!");
            return null;
        }

        // UC6 - Verify room availability
        if (!room.isAvailable()) {
            System.out.println("✗ Room " + roomId + " is not available for booking!");
            return null;
        }

        // UC6 - Create reservation (auto-generates ID)
        ReservationUC6 reservation = new ReservationUC6(
            customerName, roomId, room.getRoomType(), 
            room.getPrice(), checkInDate, checkOutDate);

        // UC6 - Allocate room to customer (mark as unavailable)
        room.setAvailability(false);

        // Store confirmed reservation
        confirmedReservations.add(reservation);

        return reservation;
    }

    /**
     * Get room by ID
     */
    public RoomUC6 getRoomById(int roomId) {
        for (RoomUC6 room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    /**
     * Cancel a reservation and release room
     */
    public boolean cancelReservation(int reservationId) {
        for (ReservationUC6 reservation : confirmedReservations) {
            if (reservation.getReservationId() == reservationId) {
                // Release the room
                RoomUC6 room = getRoomById(reservation.getRoomId());
                if (room != null) {
                    room.setAvailability(true);
                }
                // Remove reservation
                confirmedReservations.remove(reservation);
                System.out.println("✓ Reservation " + reservationId + " has been cancelled!");
                System.out.println("✓ Room " + reservation.getRoomId() + " is now available!");
                return true;
            }
        }
        System.out.println("✗ Reservation not found!");
        return false;
    }

    /**
     * Get reservation by ID
     */
    public ReservationUC6 getReservationById(int reservationId) {
        for (ReservationUC6 reservation : confirmedReservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    /**
     * Display all confirmed reservations
     */
    public void displayAllReservations() {
        System.out.println("\n========================================");
        System.out.println("    ALL CONFIRMED RESERVATIONS");
        System.out.println("========================================");

        if (confirmedReservations.isEmpty()) {
            System.out.println("No confirmed reservations yet!");
            System.out.println("========================================\n");
            return;
        }

        System.out.println("Total Reservations: " + confirmedReservations.size() + "\n");

        for (ReservationUC6 reservation : confirmedReservations) {
            reservation.displayDetails();
        }

        System.out.println("========================================\n");
    }

    /**
     * Get all reservations
     */
    public ArrayList<ReservationUC6> getAllReservations() {
        return confirmedReservations;
    }

    /**
     * Get all rooms
     */
    public ArrayList<RoomUC6> getAllRooms() {
        return rooms;
    }

    /**
     * Display occupancy statistics
     */
    public void displayOccupancyStats() {
        int totalRooms = rooms.size();
        int bookedRooms = totalRooms - getAvailableRoomsCount();

        System.out.println("\n========================================");
        System.out.println("    OCCUPANCY STATISTICS");
        System.out.println("========================================");
        System.out.println("Total Rooms: " + totalRooms);
        System.out.println("Available Rooms: " + getAvailableRoomsCount());
        System.out.println("Booked Rooms: " + bookedRooms);
        System.out.println("Confirmed Reservations: " + confirmedReservations.size());
        System.out.println("Occupancy Rate: " + 
            String.format("%.1f%%", (bookedRooms * 100.0 / totalRooms)));
        System.out.println("========================================\n");
    }

    /**
     * Get count of available rooms
     */
    private int getAvailableRoomsCount() {
        int count = 0;
        for (RoomUC6 room : rooms) {
            if (room.isAvailable()) {
                count++;
            }
        }
        return count;
    }
}
