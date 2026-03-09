/**
 * UC4 - Room Class for Search & Availability
 * Represents a room with searchable properties
 */
public class RoomUC4 {
    private int roomId;
    private String roomType;
    private double price;
    private boolean availability;

    public RoomUC4(int roomId, String roomType, double price, boolean availability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.availability = availability;
    }

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

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void displaySearchResult() {
        System.out.println("  Room ID: " + roomId + 
                         " | Type: " + roomType + 
                         " | Price: Rs. " + price + 
                         " | Status: " + (availability ? "✓ Available" : "✗ Not Available"));
    }

    @Override
    public String toString() {
        return "Room{" + "ID=" + roomId + ", Type='" + roomType + 
               "', Price=" + price + ", Available=" + availability + '}';
    }
}
