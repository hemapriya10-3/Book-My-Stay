# UC4 - Room Search & Availability Check

## Overview
This use case implements comprehensive room search functionality with availability checks.

## Features Implemented

### 1. Search by Room Type
```java
ArrayList<RoomUC4> searchByRoomType(String roomType)
- Search all rooms matching the type
- Returns ArrayList of matching rooms
- Case-insensitive comparison
```

### 2. Search Available Rooms by Type
```java
ArrayList<RoomUC4> searchAvailableRoomsByType(String roomType)
- Search rooms matching type AND available
- Only returns rooms that can be booked
- Returns filtered ArrayList
```

### 3. Display Available Rooms
```java
void displayAllAvailableRooms()
- Shows all available rooms in inventory
- Displays: Room ID, Type, Price, Status
- Shows count of available rooms
```

### 4. Availability Check
```java
boolean isRoomAvailable(int roomId)
- Check if specific room is available
- Returns true/false
- Used before booking
```

### 5. Display by Room Type
```java
void displayAvailableRoomsByType(String roomType)
- Shows formatted list of available rooms by type
- Grouped by category
- Includes count and details
```

## Search Criteria

### By Type
- Single Room (Rs. 1500)
- Double Room (Rs. 2500)
- Deluxe Room (Rs. 4000)
- Suite (Rs. 6000)

### By Availability
- Available rooms only
- All rooms (including booked)

## Sample Output

```
╔════════════════════════════════════════╗
║  UC4 - ROOM SEARCH & AVAILABILITY    ║
╚════════════════════════════════════════╝

========================================
        ROOM SEARCH MENU
========================================
1. View All Room Types
2. View All Available Rooms
3. Search Available Rooms by Type
4. Check Specific Room Availability
5. View Search Statistics
6. Exit
========================================
Enter your choice (1-6): 2

========================================
        ALL AVAILABLE ROOMS
========================================
Total Available: 8

  Room ID: 101 | Type: Single Room | Price: Rs. 1500.0 | Status: ✓ Available
  Room ID: 102 | Type: Single Room | Price: Rs. 1500.0 | Status: ✓ Available
  Room ID: 201 | Type: Double Room | Price: Rs. 2500.0 | Status: ✓ Available
  ...

========================================
        ROOM SEARCH MENU
========================================
...
Enter your choice (1-6): 3

========================================
    SELECT ROOM TYPE
========================================
1. Single Room
2. Double Room
3. Deluxe Room
4. Suite
========================================
Enter room type choice (1-4): 2

========================================
    AVAILABLE DOUBLE ROOMS
========================================
Found: 2 available

  Room ID: 201 | Type: Double Room | Price: Rs. 2500.0 | Status: ✓ Available
  Room ID: 202 | Type: Double Room | Price: Rs. 2500.0 | Status: ✓ Available
========================================

All Double Rooms in Inventory (3 total):
  Room ID: 201 | Type: Double Room | Price: Rs. 2500.0 | Status: ✓ Available
  Room ID: 202 | Type: Double Room | Price: Rs. 2500.0 | Status: ✓ Available
  Room ID: 203 | Type: Double Room | Price: Rs. 2500.0 | Status: ✗ Not Available

========================================
        ROOM SEARCH MENU
========================================
...
Enter your choice (1-6): 4

========================================
    CHECK ROOM AVAILABILITY
========================================
Enter Room ID to check: 201

--- Room Details ---
Room ID: 201
Room Type: Double Room
Price: Rs. 2500.0 per night
Status: ✓ AVAILABLE

✓ This room is available for booking!

========================================
        ROOM SEARCH MENU
========================================
...
Enter your choice (1-6): 5

========================================
        SEARCH STATISTICS
========================================
Total Rooms: 12
Available Rooms: 8
Booked Rooms: 4
Availability Rate: 66.7%
========================================
```

## Code Structure

```
SearchManagementUC4
├── initializeRooms()                → Init 12 rooms
├── displayAllRoomTypes()            → Show room types list
├── searchByRoomType(String)         → Search all by type
├── searchAvailableRoomsByType(String) → Search available by type
├── displayAllAvailableRooms()       → Show all available
├── displayAvailableRoomsByType(String) → Show available by type
├── isRoomAvailable(int)             → Check availability
├── getRoomById(int)                 → Find room by ID
├── getAvailableRoomsCount()         → Count available
├── displaySearchStats()             → Show statistics
└── getAllRooms()                    → Get all rooms

MainUC4
├── main()                           → Entry point
├── searchMenu()                     → Interactive menu
├── searchByType()                   → Type search process
└── checkAvailability()              → Availability check process
```

## Search Methods Comparison

| Method | Returns | Filter |
|--------|---------|--------|
| `searchByRoomType()` | ArrayList<Room> | Type only |
| `searchAvailableRoomsByType()` | ArrayList<Room> | Type + Available |
| `isRoomAvailable()` | boolean | Available by ID |
| `displayAllAvailableRooms()` | void | Shows all available |

## How to Run

Compile:
```bash
javac RoomUC4.java SearchManagementUC4.java MainUC4.java
```

Run:
```bash
java MainUC4
```

## Key Concepts

- **ArrayList Filtering**: Using loops to filter results
- **String Comparison**: Case-insensitive type matching
- **Search Results**: Returning filtered collections
- **Formatted Display**: Presenting search results clearly
- **Status Indicators**: Visual representation (✓, ✗)
- **Statistics**: Calculated metrics

## Data Structures

```java
ArrayList<RoomUC4> rooms;       // All rooms
ArrayList<RoomUC4> searchResults; // Search results

Room properties:
- roomId (int)
- roomType (String)
- price (double)
- availability (boolean)
```

## Use Cases for Each Search Method

### searchByRoomType()
- Admin: View all rooms of a category
- Analytics: Count rooms by type
- Maintenance: Updates to specific type

### searchAvailableRoomsByType()
- Customer: Find available rooms to book
- UI: Display booking options
- Scheduling: Plan availability

### isRoomAvailable()
- Pre-booking validation
- Room detail page check
- Booking confirmation process

### displayAllAvailableRooms()
- Dashboard view
- Available capacity overview
- Quick status check

## Next Steps
- UC5: Implement booking with search integration
- UC6: Confirmation with room allocation
- Enhancement: Advanced search filters (price range, amenities)
