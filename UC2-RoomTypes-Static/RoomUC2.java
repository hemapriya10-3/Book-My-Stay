/**
 * UC2 - Room Class with Basic Room Types & Static Availability
 * Defines different room types:
 * - Single Room
 * - Double Room
 * - Deluxe Room
 * - Suite
 */
public class RoomUC2 {
    private int roomId;
    private String roomType;
    private double price;
    private boolean availability;

    // Constructor
    public RoomUC2(int roomId, String roomType, double price, boolean availability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.availability = availability;
    }

    // Getters
    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return availability;
    }

    // Setters
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * Display room details in formatted way
     */
    public void displayDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: Rs. " + price);
        System.out.println("Status: " + (availability ? "Available" : "Not Available"));
        System.out.println("---------------------------------------------");
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", availability=" + (availability ? "Available" : "Not Available") +
                '}';
    }
}
