# UC3 - Centralized Room Inventory Management

## Overview
This use case implements centralized inventory management allowing operations on rooms stored in an ArrayList.

## Features Implemented

### 1. ArrayList-Based Inventory
- Use `ArrayList<Room>` to store all rooms
- Dynamic size management
- Easy add/remove operations

### 2. Inventory Operations

#### Add Room
```java
void addRoom(Room room)
- Creates new room object
- Adds to ArrayList
- Displays confirmation
```

#### Remove Room
```java
void removeRoom(int roomId)
- Searches for room by ID
- Removes from ArrayList
- Uses Iterator for safe removal
```

#### Update Availability
```java
void updateRoomAvailability(int roomId, boolean isAvailable)
- Finds room by ID
- Updates availability status
- Common for bookings/cancellations
```

#### Display All Rooms
```java
void displayAllRooms()
- Shows all rooms grouped by type
- Displays: Room ID, Price, Status
- Formatted output
```

### 3. Inventory Statistics
- Total room count
- Available rooms count
- Unavailable rooms count
- Occupancy rate percentage

## Sample Output

```
╔════════════════════════════════════════╗
║ UC3 - INVENTORY MANAGEMENT SYSTEM     ║
╚════════════════════════════════════════╝

========================================
    INVENTORY MANAGEMENT MENU
========================================
1. Display All Rooms
2. Display Inventory Stats
3. Add New Room
4. Remove Room by ID
5. Update Room Availability
6. Exit
========================================
Enter your choice (1-6): 1

========================================
     CENTRALIZED ROOM INVENTORY
========================================
Total Rooms: 12
----------------------------------------

SINGLE ROOM:
  ID: 101 | Price: Rs. 1500.0 | Status: Available
  ID: 102 | Price: Rs. 1500.0 | Status: Available
  ID: 103 | Price: Rs. 1500.0 | Status: Not Available

DOUBLE ROOM:
  ID: 201 | Price: Rs. 2500.0 | Status: Available
  ...

========================================
    INVENTORY MANAGEMENT MENU
========================================
...
Enter your choice (1-6): 2

========================================
     INVENTORY STATISTICS
========================================
Total Rooms:        12
Available Rooms:    8
Unavailable Rooms:  4
Occupancy Rate:     33.33%
========================================

========================================
    INVENTORY MANAGEMENT MENU
========================================
...
Enter your choice (1-6): 3

======= ADD NEW ROOM =======
Enter Room ID: 501
Enter Room Type (Single Room/Double Room/Deluxe Room/Suite): Studio
Enter Price per Night: Rs. 3000
Is room available? (true/false): true
✓ Room 501 added successfully!
  Room Type: Studio
  Price: Rs. 3000.0

========================================
    INVENTORY MANAGEMENT MENU
========================================
...
Enter your choice (1-6): 4

======= REMOVE ROOM =======
Enter Room ID to remove: 501
✓ Room 501 (Studio) removed successfully!

========================================
    INVENTORY MANAGEMENT MENU
========================================
...
Enter your choice (1-6): 5

======= UPDATE AVAILABILITY =======
Enter Room ID: 103
Is available? (true/false): true
✓ Room 103 availability updated to: Available
```

## Code Structure

```
InventoryManagementUC3
├── initializeRooms()              → Init 12 rooms
├── addRoom(Room)                  → Add new room
├── removeRoom(int)                → Remove by ID
├── updateRoomAvailability(int, boolean) → Update status
├── displayAllRooms()              → Show all rooms
├── displayRoomsByType(String)     → Show rooms by type
├── displayInventoryStats()        → Show statistics
├── getRoomById(int)               → Find room
├── getTotalRooms()                → Count total
├── getAvailableRoomsCount()       → Count available
└── getUnavailableRoomsCount()     → Count unavailable

MainUC3
├── main()                         → Entry point
├── managementMenu()               → Interactive menu
├── addNewRoom()                   → Add room process
├── removeRoomByID()               → Remove room process
└── updateAvailability()           → Update process
```

## How to Run

Compile:
```bash
javac RoomUC3.java InventoryManagementUC3.java MainUC3.java
```

Run:
```bash
java MainUC3
```

## Key Concepts

- **ArrayList**: Dynamic array for inventory
- **Iterator**: Safe removal of elements
- **Encapsulation**: Private data with public methods
- **CRUD Operations**: Create, Read, Update operations
- **Search & Update**: Find and modify room objects
- **Statistics**: Metrics and reporting

## Data Structures

```java
ArrayList<RoomUC3> rooms;

Room contains:
- roomId (int)
- roomType (String)
- price (double)
- availability (boolean)
```

## Persistence Note
⚠️ This implementation uses in-memory storage only.
Data is lost when application closes.
Next phase: Add file/database persistence.

## Next Steps
- UC4: Implement room search functionality
- UC5: Implement booking functionality
- Enhancement: File persistence (JSON/CSV)
