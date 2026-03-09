import java.util.ArrayList;
import java.util.Scanner;

/**
 * UC6 - Reservation Confirmation & Room Allocation
 * Demonstrates:
 * - Confirm reservation if room is available
 * - Allocate room to customer
 * - Generate and display Reservation ID
 * - Show Customer Name, Room Type, Booking Dates
 */
public class MainUC6 {
    private static ReservationManagementUC6 reservationManagement;
    private static Scanner scanner;

    public static void main(String[] args) {
        reservationManagement = new ReservationManagementUC6();
        scanner = new Scanner(System.in);

        System.out.println("\n========================================");
        System.out.println("UC6 - RESERVATION CONFIRMATION SYSTEM");
        System.out.println("========================================\n");

        reservationMenu();

        scanner.close();
    }

    /**
     * Interactive reservation menu
     */
    private static void reservationMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("    RESERVATION SYSTEM MENU");
            System.out.println("========================================");
            System.out.println("1. Confirm New Reservation");
            System.out.println("2. View All Reservations");
            System.out.println("3. View Reservation Details");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View Available Rooms");
            System.out.println("6. View Occupancy Statistics");
            System.out.println("7. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice (1-7): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        confirmNewReservation();
                        break;
                    case 2:
                        reservationManagement.displayAllReservations();
                        break;
                    case 3:
                        viewReservationDetails();
                        break;
                    case 4:
                        cancelReservation();
                        break;
                    case 5:
                        displayAvailableRooms();
                        break;
                    case 6:
                        reservationManagement.displayOccupancyStats();
                        break;
                    case 7:
                        running = false;
                        System.out.println("\n✓ Exiting Reservation System...\n");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1-7.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    /**
     * UC6 - Confirm new reservation and allocate room
     */
    private static void confirmNewReservation() {
        System.out.println("\n========================================");
        System.out.println("     CONFIRM RESERVATION");
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

            // UC6 - Confirm reservation and allocate room
            ReservationUC6 reservation = reservationManagement.confirmReservation(
                customerName, roomId, checkInDate, checkOutDate);

            if (reservation != null) {
                // UC6 - Display confirmation with all details
                reservation.displayConfirmation();
            } else {
                System.out.println("\n✗ Reservation failed! Please check room availability.");
            }

        } catch (Exception e) {
            System.out.println("Error confirming reservation! Please check your input.");
            scanner.nextLine();
        }
    }

    /**
     * View details of specific reservation
     */
    private static void viewReservationDetails() {
        System.out.println("\n========================================");
        System.out.println("    VIEW RESERVATION DETAILS");
        System.out.println("========================================");

        try {
            System.out.print("Enter Reservation ID: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            ReservationUC6 reservation = reservationManagement.getReservationById(reservationId);

            if (reservation == null) {
                System.out.println("✗ Reservation not found!");
                return;
            }

            System.out.println("\n========================================");
            System.out.println("    RESERVATION DETAILS");
            System.out.println("========================================");
            System.out.println("Reservation ID: " + String.format("%05d", reservation.getReservationId()));
            System.out.println("Customer Name: " + reservation.getCustomerName());
            System.out.println("Room Type: " + reservation.getRoomType());
            System.out.println("Room ID: " + reservation.getRoomId());
            System.out.println("Check-in Date: " + reservation.getCheckInDate());
            System.out.println("Check-out Date: " + reservation.getCheckOutDate());
            System.out.println("Room Price: Rs. " + reservation.getRoomPrice() + " per night");
            System.out.println("Total Price: Rs. " + reservation.getTotalPrice());
            System.out.println("Status: " + reservation.getConfirmationStatus());
            System.out.println("Confirmed At: " + reservation.getConfirmationTime());
            System.out.println("========================================\n");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid reservation ID.");
            scanner.nextLine();
        }
    }

    /**
     * Cancel a reservation and release room
     */
    private static void cancelReservation() {
        System.out.println("\n========================================");
        System.out.println("     CANCEL RESERVATION");
        System.out.println("========================================");

        try {
            System.out.print("Enter Reservation ID to cancel: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            reservationManagement.cancelReservation(reservationId);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid reservation ID.");
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

        ArrayList<RoomUC6> rooms = reservationManagement.getAllRooms();
        int count = 0;

        System.out.println("Room ID | Room Type      | Price (Rs.)");
        System.out.println("--------|----------------|----------");

        for (RoomUC6 room : rooms) {
            if (room.isAvailable()) {
                System.out.printf("   %-2d  | %-14s | %.2f\n", 
                    room.getRoomId(), room.getRoomType(), room.getPrice());
                count++;
            }
        }

        System.out.println("--------|----------------|----------");
        System.out.println("Total Available Rooms: " + count);
        System.out.println("========================================\n");
    }
}
