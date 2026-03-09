# Quick Reference & Testing Guide

## Menu Options

```
1. View Room Types          → Display all 4 room types and prices
2. Search Available Rooms   → Search rooms by type (shows only available)
3. Book a Room             → Create new booking with validation
4. View All Rooms          → See complete inventory with status
5. View All Bookings       → List all confirmed/cancelled bookings
6. Cancel a Booking        → Cancel a booking by booking ID
7. Exit                    → Close application
```

## Testing Scenarios

### Test 1: View Room Types
```
Input: 1
Expected Output: Display all 4 room types with prices
```

### Test 2: Search Available Rooms
```
Input: 2 → 2 (Double Room)
Expected Output: Shows rooms 201, 202 as available
```

### Test 3: Book a Room (Success)
```
Input: 3
Name: John Doe
Room ID: 101
Check-in: 15-03-2026
Check-out: 20-03-2026
Expected Output: Booking ID 1001 confirmed, Room 101 marked unavailable
```

### Test 4: Book Unavailable Room (Failure)
```
Input: 3
Room ID: 103 (unavailable from start)
Expected Output: "Room is not available" error message
```

### Test 5: Book Non-existent Room (Failure)
```
Input: 3
Room ID: 999
Expected Output: "Room not found" error message
```

### Test 6: View All Bookings
```
Input: 5
Expected Output: List of all bookings with ID 1001, 1002, etc.
```

### Test 7: Cancel Booking
```
Input: 6
Booking ID: 1001
Expected Output: Booking cancelled, room becomes available again
```

## Code Flow

```
Main.main()
    ↓
displayWelcomeScreen()
    ↓
mainMenu() [Loop]
    ├→ viewRoomTypes()
    ├→ searchAvailableRooms() → HotelManagement.displayAvailableRoomsByType()
    ├→ bookRoom() → HotelManagement.bookRoom() → Booking created
    ├→ viewAllRooms() → HotelManagement.displayAllRooms()
    ├→ viewAllBookings()
    ├→ cancelBooking() → HotelManagement.cancelBooking()
    └→ exitApplication()
```

## Object Relationships

```
HotelManagement
    ├── ArrayList<Room> rooms
    │   └── 12 Room objects initialized
    └── ArrayList<Booking> bookings
        └── Booking objects created on booking
        
Room object
    ├── roomId: int
    ├── roomType: String
    ├── price: double
    └── availability: boolean

Booking object
    ├── bookingId: int (auto-incremented from 1001)
    ├── customerName: String
    ├── roomId: int (reference to Room)
    ├── checkInDate: String
    ├── checkOutDate: String
    ├── totalPrice: double
    └── bookingStatus: String
```

## Key Validations

1. **Room Availability Check**: Before booking, verify room.isAvailable() == true
2. **Room Existence Check**: Ensure room ID exists in inventory
3. **Input Validation**: Catch NumberFormatException and InputMismatchException
4. **Booking Status**: Auto-set to "Confirmed" on creation
5. **Availability Update**: Room marked unavailable when booked, available when cancelled

## Initial Room Status

```
SINGLE ROOMS (101-103):      101✓, 102✓, 103✗
DOUBLE ROOMS (201-203):      201✓, 202✓, 203✗
DELUXE ROOMS (301-303):      301✓, 302✓, 303✗
SUITES (401-403):            401✓, 402✗, 403✓

✓ = Available
✗ = Not Available
```

## Compilation & Execution

```bash
# From IntelliJ IDEA:
1. Right-click Main.java
2. Click Run 'Main.main()'

# Or from command line:
cd c:\Users\vjk51\Desktop\step\HostelBooking
javac -d src src/com/hostel/Main.java
java -cp src com.hostel.Main
```

## No External Dependencies

This project uses only Java core libraries:
- java.util.ArrayList
- java.util.Iterator
- java.util.Scanner

No external jars or dependencies required!

## File Sizes

- Room.java: ~1.2 KB
- Booking.java: ~1.5 KB
- HotelManagement.java: ~4.5 KB
- Main.java: ~5.2 KB
- Total: ~12.4 KB

## Important Notes

1. All room IDs and booking IDs are auto-generated
2. Booking IDs start from 1001 and increment
3. Room availability is automatically managed
4. All validations are in-place before booking
5. No database needed - all data is in-memory (ArrayList)
6. Application is fully functional as a standalone Java program

## Possible Extensions

- Add file persistence (save/load bookings)
- Add guest profiles/history
- Add special offers/discounts
- Add multi-language support
- Add booking modification feature
- Add room rating system
- Add admin login
- Add database connectivity
