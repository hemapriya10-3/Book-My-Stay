# Hostel Booking System

A comprehensive Java-based hostel/hotel booking management application implementing all required use cases.

## Project Structure

```
HostelBooking/
├── src/
│   └── com/
│       └── hostel/
│           ├── Main.java                          (Entry point - UC1)
│           ├── entities/
│           │   ├── Room.java                      (Room entity - UC2)
│           │   └── Booking.java                   (Booking entity - UC6)
│           └── management/
│               └── HotelManagement.java           (Core management logic - UC3, UC4, UC5)
└── README.md
```

## Features Implemented

### UC1 - Application Entry & Welcome Message
- Welcome screen on startup
- Main menu with 7 options
- User-friendly navigation

### UC2 - Basic Room Types & Static Availability
- 4 room types: Single Room, Double Room, Deluxe Room, Suite
- Each room has: ID, Type, Price, Availability status
- Static initialization with 12 rooms (3 per type)

### UC3 - Centralized Room Inventory Management
- ArrayList-based room inventory
- Methods: addRoom(), removeRoom(), updateRoomAvailability(), displayAllRooms()
- Real-time inventory tracking

### UC4 - Room Search & Availability Check
- Search by room type
- Display available rooms with details
- Price information for each room

### UC5 - Booking Request
- Customer name input
- Room ID selection
- Check-in/Check-out date entry
- Automatic availability validation

### UC6 - Reservation Confirmation & Room Allocation
- Unique Booking ID generation (1000+)
- Automatic room allocation
- Confirmation display with all details

### Optional Enhancements
- ✅ Cancel booking functionality
- ✅ View all bookings
- Room availability updates on booking/cancellation

## How to Run in IntelliJ IDEA

### Step 1: Create Project
1. Open IntelliJ IDEA
2. Click **File > New > Project**
3. Select **Java** as language
4. Set Project name: **HostelBooking**
5. Click **Create**

### Step 2: Create Folder Structure
1. Right-click on **src** folder
2. New > Package
3. Enter: `com.hostel.entities` → Create
4. Repeat for: `com.hostel.management`
5. Package `com.hostel` is created automatically

### Step 3: Add Java Files
1. Copy all `.java` files to their respective package directories
2. Or manually create files:
   - `com.hostel.Main.java` (in src/com/hostel/)
   - `com.hostel.entities.Room.java`
   - `com.hostel.entities.Booking.java`
   - `com.hostel.management.HotelManagement.java`

### Step 4: Configure Project SDK (if needed)
1. File > Project Structure
2. Check Project SDK is set to Java 8 or higher
3. Click OK

### Step 5: Run Application
1. Open **Main.java**
2. Right-click and select **Run 'Main.main()'**
   - OR Click the green play button (▶) next to main()
   - OR Press **Shift + F10** (Windows)
3. Application runs in IntelliJ console

## Sample Output

```
╔════════════════════════════════════════╗
║   WELCOME TO HOSTEL BOOKING SYSTEM    ║
╚════════════════════════════════════════╝
Your trusted platform for affordable accommodation!

========================================
           MAIN MENU
========================================
1. View Room Types
2. Search Available Rooms
3. Book a Room
4. View All Rooms
5. View All Bookings
6. Cancel a Booking
7. Exit
========================================
Enter your choice (1-7): 1

========================================
        AVAILABLE ROOM TYPES
========================================
1. Single Room      - Rs. 1500 per night
2. Double Room      - Rs. 2500 per night
3. Deluxe Room      - Rs. 4000 per night
4. Suite            - Rs. 6000 per night
========================================

========================================
           MAIN MENU
========================================
...
Enter your choice (1-7): 3

========================================
           BOOK A ROOM
========================================
Enter your name: Rajesh Kumar
Enter room ID to book: 201
Enter check-in date (DD-MM-YYYY): 15-03-2026
Enter check-out date (DD-MM-YYYY): 18-03-2026

========================================
       BOOKING CONFIRMATION
========================================
Booking ID: 1001
Customer Name: Rajesh Kumar
Room ID: 201
Check-in Date: 15-03-2026
Check-out Date: 18-03-2026
Total Price: Rs. 2500.0
Status: Confirmed
========================================
Thank you for booking! Have a great stay!

========================================
           MAIN MENU
========================================
...
```

## Room Pricing

| Room Type   | Price per Night |
|------------|-----------------|
| Single Room | Rs. 1500        |
| Double Room | Rs. 2500        |
| Deluxe Room | Rs. 4000        |
| Suite       | Rs. 6000        |

## Initial Room Inventory

**Single Rooms:** 101, 102, 103 (101, 102 available)
**Double Rooms:** 201, 202, 203 (201, 202 available)
**Deluxe Rooms:** 301, 302, 303 (301, 302 available)
**Suites:** 401, 402, 403 (401, 403 available)

## Class Details

### Room.java
- Properties: roomId, roomType, price, availability
- Methods: Getters/Setters, displayDetails(), toString()

### Booking.java
- Properties: bookingId, customerName, roomId, checkInDate, checkOutDate, totalPrice, bookingStatus
- Auto-incremental booking ID starting from 1001
- Methods: Getters/Setters, displayBookingDetails(), toString()

### HotelManagement.java
- ArrayList-based room and booking management
- Key methods:
  - initializeRooms() - Initialize with static data
  - addRoom(), removeRoom(), updateRoomAvailability()
  - displayAllRooms(), displayRoomTypes()
  - searchByRoomType(), displayAvailableRoomsByType()
  - isRoomAvailable(), bookRoom()
  - cancelBooking(), displayAllBookings()

### Main.java
- Entry point with Scanner for user input
- mainMenu() - Main navigation loop
- Individual methods for each feature
- Error handling for invalid inputs

## Future Enhancements

- File-based persistence (save/load from JSON or CSV)
- Database integration (MySQL/PostgreSQL)
- Payment gateway integration
- Email confirmation
- Rating and review system
- User authentication and profiles
- Admin panel for management

## Requirements

- Java 8 or higher
- IntelliJ IDEA 2020 or later

## Author

Hostel Booking System v1.0

## License

Open source - Free to use and modify
