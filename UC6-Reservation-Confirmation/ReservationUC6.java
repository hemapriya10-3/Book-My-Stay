/**
 * UC6 - Reservation Class for Reservation Confirmation & Room Allocation
 * Represents a confirmed reservation with auto-generated ID
 */
public class ReservationUC6 {
    private static int reservationCounter = 5000;
    private int reservationId;
    private String customerName;
    private int roomId;
    private String roomType;
    private double roomPrice;
    private String checkInDate;
    private String checkOutDate;
    private double totalPrice;
    private String confirmationStatus;
    private String confirmationTime;

    public ReservationUC6(String customerName, int roomId, String roomType, 
                         double roomPrice, String checkInDate, String checkOutDate) {
        this.reservationId = ++reservationCounter;
        this.customerName = customerName;
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = roomPrice;  // Can be extended to calculate nights
        this.confirmationStatus = "CONFIRMED";
        this.confirmationTime = java.time.LocalDateTime.now().toString();
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getConfirmationStatus() {
        return confirmationStatus;
    }

    public String getConfirmationTime() {
        return confirmationTime;
    }

    // Setters
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * UC6 - Display reservation confirmation
     * Shows all reservation details with Reservation ID, Customer Name, Room Type, Booking Dates
     */
    public void displayConfirmation() {
        System.out.println("\n========================================");
        System.out.println("    RESERVATION CONFIRMATION");
        System.out.println("========================================");
        System.out.println();
        System.out.println("  Reservation ID....... : " + String.format("%05d", reservationId));
        System.out.println("  Customer Name........ : " + customerName);
        System.out.println("  Room Type............ : " + roomType);
        System.out.println("  Room ID.............. : " + roomId);
        System.out.println("  Room Price........... : Rs. " + String.format("%.2f", roomPrice) + " per night");
        System.out.println("  Check-in Date........ : " + checkInDate);
        System.out.println("  Check-out Date....... : " + checkOutDate);
        System.out.println("  Total Price.......... : Rs. " + String.format("%.2f", totalPrice));
        System.out.println("  Status............... : " + confirmationStatus);
        System.out.println("  Confirmed At......... : " + confirmationTime);
        System.out.println();
        System.out.println("  ** Room has been allocated to you!");
        System.out.println("  ** Please save your Reservation ID!");
        System.out.println("  ** Thank you for booking with us!");
        System.out.println();
        System.out.println("========================================\n");
    }

    /**
     * Display reservation details in list format
     */
    public void displayDetails() {
        System.out.println("\nReservation ID: " + String.format("%05d", reservationId));
        System.out.println("Customer: " + customerName);
        System.out.println("Room Type: " + roomType + " (ID: " + roomId + ")");
        System.out.println("Check-in: " + checkInDate + " → Check-out: " + checkOutDate);
        System.out.println("Price: Rs. " + String.format("%.2f", totalPrice));
        System.out.println("Status: " + confirmationStatus);
        System.out.println("---------------------------------------------");
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "ID=" + reservationId +
                ", Customer='" + customerName + '\'' +
                ", RoomType='" + roomType + '\'' +
                ", CheckIn='" + checkInDate + '\'' +
                ", CheckOut='" + checkOutDate + '\'' +
                ", Price=" + totalPrice +
                ", Status='" + confirmationStatus + '\'' +
                '}';
    }
}
