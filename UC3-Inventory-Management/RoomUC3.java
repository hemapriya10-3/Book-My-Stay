/**
 * UC3 - Room Class for Inventory Management
 * Represents a room with ID, Type, Price, and Availability
 */
public class RoomUC3 {
    private int roomId;
    private String roomType;
    private double price;
    private boolean availability;

    public RoomUC3(int roomId, String roomType, double price, boolean availability) {
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

    @Override
    public String toString() {
        return "Room{" + "ID=" + roomId + ", Type='" + roomType + 
               "', Price=" + price + ", Status=" + (availability ? "Available" : "Not Available") + '}';
    }
}
