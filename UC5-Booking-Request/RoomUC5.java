/**
 * UC5 - Room Class for Booking Request
 * Represents a room with booking capabilities
 */
public class RoomUC5 {
    private int roomId;
    private String roomType;
    private double price;
    private boolean availability;

    public RoomUC5(int roomId, String roomType, double price, boolean availability) {
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

    public void displayDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: Rs. " + price);
        System.out.println("Status: " + (availability ? "Available" : "Not Available"));
    }

    @Override
    public String toString() {
        return "Room{" + "ID=" + roomId + ", Type='" + roomType + 
               "', Price=" + price + ", Available=" + availability + '}';
    }
}
