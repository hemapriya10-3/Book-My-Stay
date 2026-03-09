/**
 * UC6 - Room Class for Reservation Confirmation
 */
public class RoomUC6 {
    private int roomId;
    private String roomType;
    private double price;
    private boolean availability;

    public RoomUC6(int roomId, String roomType, double price, boolean availability) {
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
               "', Price=" + price + ", Available=" + availability + '}';
    }
}
