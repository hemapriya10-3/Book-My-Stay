import java.util.ArrayList;
import java.util.Scanner;

/**
 * UC5 - Booking Request
 * Demonstrates booking request with validation:
 * - User enters: Name, Room ID, Check-in date, Check-out date
 * - Validate all inputs before booking
 * - Display validation results
 */
public class MainUC5 {
    private static BookingManagementUC5 bookingManagement;
    private static Scanner scanner;

    public static void main(String[] args) {
        bookingManagement = new BookingManagementUC5();
        scanner = new Scanner(System.in);

        System.out.println("\n========================================");
        System.out.println("     UC5 - BOOKING REQUEST SYSTEM");
        System.out.println("========================================\n");

        bookingMenu();

        scanner.close();
    }

    /**
     * Interactive booking menu
     */
    private static void bookingMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("       BOOKING REQUEST MENU");
            System.out.println("========================================");
            System.out.println("1. Create New Booking Request");
            System.out.println("2. View Available Rooms");
            System.out.println("3. View All Booking Requests");
            System.out.println("4. View Validated Requests");
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createBookingRequest();
                        break;
                    case 2:
                        displayAvailableRooms();
                        break;
                    case 3:
                        bookingManagement.displayAllBookingRequests();
                        break;
                    case 4:
                        displayValidatedRequests();
                        break;
                    case 5:
                        running = false;
                        System.out.println("\n✓ Exiting Booking Request System...\n");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1-5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    /**
     * UC5 - Create booking request with validation
     */
    private static void createBookingRequest() {
        System.out.println("\n========================================");
        System.out.println("     CREATE BOOKING REQUEST");
        System.out.println("========================================");

        try {
            // Input customer name
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            // Input room ID
            System.out.print("Enter Room ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();

            // Input check-in date
            System.out.print("Enter Check-in Date (DD-MM-YYYY): ");
            String checkInDate = scanner.nextLine();

            // Input check-out date
            System.out.print("Enter Check-out Date (DD-MM-YYYY): ");
            String checkOutDate = scanner.nextLine();

            // Create booking request
            BookingUC5 bookingRequest = bookingManagement.createBookingRequest(
                customerName, roomId, checkInDate, checkOutDate);

            // Display booking request
            bookingRequest.displayBookingRequest();

            // UC5 - Validate booking request
            if (bookingManagement.validateBookingRequest(bookingRequest)) {
                // Store validated request
                bookingManagement.storeBookingRequest(bookingRequest);
                System.out.println("✓ Booking request saved for confirmation!");
            } else {
                System.out.println("✗ Booking request validation failed!");
                System.out.println("  Message: " + bookingRequest.getValidationMessage());
            }

        } catch (Exception e) {
            System.out.println("Error creating booking request! Please check your input.");
            scanner.nextLine();
        }
    }

    /**
     * Display available rooms
     */
    private static void displayAvailableRooms() {
        System.out.println("\n========================================");
        System.out.println("       AVAILABLE ROOMS");
        System.out.println("========================================");

        ArrayList<RoomUC5> rooms = bookingManagement.getAllRooms();
        int count = 0;

        for (RoomUC5 room : rooms) {
            if (room.isAvailable()) {
                System.out.println("ID: " + room.getRoomId() + 
                                 " | Type: " + room.getRoomType() + 
                                 " | Price: Rs. " + room.getPrice());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No available rooms!");
        } else {
            System.out.println("\nTotal Available: " + count);
        }
        System.out.println("========================================\n");
    }

    /**
     * Display validated booking requests
     */
    private static void displayValidatedRequests() {
        ArrayList<BookingUC5> validatedRequests = bookingManagement.getValidatedBookingRequests();

        System.out.println("\n========================================");
        System.out.println("   VALIDATED BOOKING REQUESTS");
        System.out.println("========================================");

        if (validatedRequests.isEmpty()) {
            System.out.println("No validated requests found!");
            System.out.println("========================================\n");
            return;
        }

        for (int i = 0; i < validatedRequests.size(); i++) {
            BookingUC5 request = validatedRequests.get(i);
            System.out.println("\nRequest #" + (i + 1));
            System.out.println("Customer: " + request.getCustomerName());
            System.out.println("Room ID: " + request.getRoomId());
            System.out.println("Check-in: " + request.getCheckInDate());
            System.out.println("Check-out: " + request.getCheckOutDate());
            System.out.println("Room Price: Rs. " + request.getRoomPrice() + " per night");
            System.out.println("Status: ✓ Validated and Ready for Confirmation");
            System.out.println("---------------------------------------------");
        }

        System.out.println("\n========================================\n");
    }
}
