
import java.util.ArrayList;

/**
 * UC5 - Booking Management for Booking Request
 * Manages booking requests with validation
 */
public class BookingManagementUC5 {
    private ArrayList<RoomUC5> rooms;
    private ArrayList<BookingUC5> bookingRequests;

    public BookingManagementUC5() {
        this.rooms = new ArrayList<>();
        this.bookingRequests = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Initialize rooms with static data
     */
    private void initializeRooms() {
        // Single Rooms
        rooms.add(new RoomUC5(101, "Single Room", 1500, true));
        rooms.add(new RoomUC5(102, "Single Room", 1500, true));
        rooms.add(new RoomUC5(103, "Single Room", 1500, false));

        // Double Rooms
        rooms.add(new RoomUC5(201, "Double Room", 2500, true));
        rooms.add(new RoomUC5(202, "Double Room", 2500, true));
        rooms.add(new RoomUC5(203, "Double Room", 2500, false));

        // Deluxe Rooms
        rooms.add(new RoomUC5(301, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC5(302, "Deluxe Room", 4000, true));
        rooms.add(new RoomUC5(303, "Deluxe Room", 4000, false));

        // Suites
        rooms.add(new RoomUC5(401, "Suite", 6000, true));
        rooms.add(new RoomUC5(402, "Suite", 6000, false));
        rooms.add(new RoomUC5(403, "Suite", 6000, true));
    }

    /**
     * UC5 - Create booking request
     */
    public BookingUC5 createBookingRequest(String customerName, int roomId, 
                                           String checkInDate, String checkOutDate) {
        RoomUC5 room = getRoomById(roomId);

        // Get room price
        double roomPrice = (room != null) ? room.getPrice() : 0;

        // Create booking request
        BookingUC5 bookingRequest = new BookingUC5(customerName, roomId, checkInDate, checkOutDate, roomPrice);

        return bookingRequest;
    }

    /**
     * UC5 - Validate booking request
     * Returns true if all validations pass
     */
    public boolean validateBookingRequest(BookingUC5 bookingRequest) {
        System.out.println("\n========================================");
        System.out.println("      VALIDATING BOOKING REQUEST");
        System.out.println("========================================");

        // Validate customer name
        if (!bookingRequest.validateCustomerName()) {
            System.out.println(bookingRequest.getValidationMessage());
            return false;
        }
        System.out.println("✓ Customer name validated");

        // Validate date format
        if (!bookingRequest.validateDateFormat()) {
            System.out.println(bookingRequest.getValidationMessage());
            return false;
        }
        System.out.println("✓ Date format validated");

        // Validate date logic
        if (!bookingRequest.validateDateLogic()) {
            System.out.println(bookingRequest.getValidationMessage());
            return false;
        }
        System.out.println("✓ Date logic validated");

        // Validate room exists
        RoomUC5 room = getRoomById(bookingRequest.getRoomId());
        if (room == null) {
            System.out.println("✗ Room ID " + bookingRequest.getRoomId() + " not found!");
            return false;
        }
        System.out.println("✓ Room exists");

        // Validate room availability
        if (!room.isAvailable()) {
            System.out.println("✗ Room " + bookingRequest.getRoomId() + " is not available!");
            bookingRequest.setValidationMessage("Room is already booked");
            return false;
        }
        System.out.println("✓ Room is available");

        System.out.println("========================================");
        System.out.println("✓ ALL VALIDATIONS PASSED!");
        System.out.println("========================================\n");

        bookingRequest.setValidated(true);
        bookingRequest.setValidationMessage("Booking request validated successfully");
        return true;
    }

    /**
     * Get room by ID
     */
    public RoomUC5 getRoomById(int roomId) {
        for (RoomUC5 room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    /**
     * Store booking request for later confirmation
     */
    public void storeBookingRequest(BookingUC5 bookingRequest) {
        bookingRequests.add(bookingRequest);
    }

    /**
     * Display all booking requests
     */
    public void displayAllBookingRequests() {
        System.out.println("\n========================================");
        System.out.println("     ALL BOOKING REQUESTS");
        System.out.println("========================================");

        if (bookingRequests.isEmpty()) {
            System.out.println("No booking requests found!");
            System.out.println("========================================\n");
            return;
        }

        for (int i = 0; i < bookingRequests.size(); i++) {
            BookingUC5 request = bookingRequests.get(i);
            System.out.println("\nRequest #" + (i + 1));
            System.out.println("Customer: " + request.getCustomerName());
            System.out.println("Room ID: " + request.getRoomId());
            System.out.println("Check-in: " + request.getCheckInDate());
            System.out.println("Check-out: " + request.getCheckOutDate());
            System.out.println("Status: " + (request.isValidated() ? "✓ Validated" : "✗ Not Validated"));
            System.out.println("---------------------------------------------");
        }
        System.out.println("\n========================================\n");
    }

    /**
     * Get all booking requests
     */
    public ArrayList<BookingUC5> getAllBookingRequests() {
        return bookingRequests;
    }

    /**
     * Get validated booking requests
     */
    public ArrayList<BookingUC5> getValidatedBookingRequests() {
        ArrayList<BookingUC5> validatedRequests = new ArrayList<>();
        for (BookingUC5 request : bookingRequests) {
            if (request.isValidated()) {
                validatedRequests.add(request);
            }
        }
        return validatedRequests;
    }

    /**
     * Get all rooms
     */
    public ArrayList<RoomUC5> getAllRooms() {
        return rooms;
    }
}
