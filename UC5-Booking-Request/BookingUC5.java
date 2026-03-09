
/**
 * UC5 - Booking Class for Booking Request
 * Represents a booking request with validation
 */
public class BookingUC5 {
    private String customerName;
    private int roomId;
    private String checkInDate;
    private String checkOutDate;
    private double roomPrice;
    private boolean isValidated;
    private String validationMessage;

    public BookingUC5(String customerName, int roomId, String checkInDate, String checkOutDate, double roomPrice) {
        this.customerName = customerName;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomPrice = roomPrice;
        this.isValidated = false;
        this.validationMessage = "";
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    // Setters
    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public void setValidationMessage(String message) {
        validationMessage = message;
    }

    /**
     * UC5 - Validate booking request
     * Check if customer name is valid
     */
    public boolean validateCustomerName() {
        if (customerName == null || customerName.trim().isEmpty()) {
            validationMessage = "✗ Customer name cannot be empty!";
            return false;
        }
        if (customerName.length() < 3) {
            validationMessage = "✗ Customer name must be at least 3 characters!";
            return false;
        }
        return true;
    }

    /**
     * UC5 - Validate dates format
     * Check if dates are in correct format (DD-MM-YYYY)
     */
    public boolean validateDateFormat() {
        if (!isValidDateFormat(checkInDate)) {
            validationMessage = "✗ Check-in date must be in format DD-MM-YYYY!";
            return false;
        }
        if (!isValidDateFormat(checkOutDate)) {
            validationMessage = "✗ Check-out date must be in format DD-MM-YYYY!";
            return false;
        }
        return true;
    }

    /**
     * Helper method to validate date format
     */
    private boolean isValidDateFormat(String date) {
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    /**
     * UC5 - Validate date logic
     * Check if check-out date is after check-in date
     */
    public boolean validateDateLogic() {
        try {
            int checkInDay = Integer.parseInt(checkInDate.substring(0, 2));
            int checkInMonth = Integer.parseInt(checkInDate.substring(3, 5));
            int checkInYear = Integer.parseInt(checkInDate.substring(6, 10));

            int checkOutDay = Integer.parseInt(checkOutDate.substring(0, 2));
            int checkOutMonth = Integer.parseInt(checkOutDate.substring(3, 5));
            int checkOutYear = Integer.parseInt(checkOutDate.substring(6, 10));

            long checkInTime = checkInYear * 10000 + checkInMonth * 100 + checkInDay;
            long checkOutTime = checkOutYear * 10000 + checkOutMonth * 100 + checkOutDay;

            if (checkOutTime <= checkInTime) {
                validationMessage = "✗ Check-out date must be after check-in date!";
                return false;
            }
            return true;
        } catch (Exception e) {
            validationMessage = "✗ Invalid date format!";
            return false;
        }
    }

    /**
     * Display booking request details
     */
    public void displayBookingRequest() {
        System.out.println("\n========================================");
        System.out.println("       BOOKING REQUEST DETAILS");
        System.out.println("========================================");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Room ID: " + roomId);
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Room Price: Rs. " + roomPrice + " per night");
        System.out.println("Status: " + (isValidated ? "✓ Validated" : "✗ Not Validated"));
        if (!validationMessage.isEmpty()) {
            System.out.println("Message: " + validationMessage);
        }
        System.out.println("========================================\n");
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "customerName='" + customerName + '\'' +
                ", roomId=" + roomId +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", roomPrice=" + roomPrice +
                ", isValidated=" + isValidated +
                '}';
    }
}
