# UC2 - Basic Room Types & Static Availability

## Overview
This use case defines the basic room structure with different room types and static data initialization.

## Features Implemented

### 1. Room Class (RoomUC2.java)
Represents a room with the following properties:
- **Room ID**: Unique identifier (101, 102, 201, etc.)
- **Room Type**: Category (Single, Double, Deluxe, Suite)
- **Price**: Per night cost in Rs.
- **Availability**: Boolean status (true/false)

### 2. Room Types Defined
```
Single Room  - Rs. 1500 per night
Double Room  - Rs. 2500 per night
Deluxe Room  - Rs. 4000 per night
Suite        - Rs. 6000 per night
```

### 3. Static Room Data Initialization
- 12 rooms total (3 per type)
- Stored in ArrayList
- Hard-coded availability from the start

### 4. Room Details Display
Show complete information for each room:
- Room ID
- Room Type
- Price per night
- Availability status

## Static Data Structure

```
SINGLE ROOMS (101-103):
├─ Room 101: Single Room, Rs. 1500, Available
├─ Room 102: Single Room, Rs. 1500, Available
└─ Room 103: Single Room, Rs. 1500, Not Available

DOUBLE ROOMS (201-203):
├─ Room 201: Double Room, Rs. 2500, Available
├─ Room 202: Double Room, Rs. 2500, Available
└─ Room 203: Double Room, Rs. 2500, Not Available

DELUXE ROOMS (301-303):
├─ Room 301: Deluxe Room, Rs. 4000, Available
├─ Room 302: Deluxe Room, Rs. 4000, Available
└─ Room 303: Deluxe Room, Rs. 4000, Not Available

SUITES (401-403):
├─ Room 401: Suite, Rs. 6000, Available
├─ Room 402: Suite, Rs. 6000, Not Available
└─ Room 403: Suite, Rs. 6000, Available
```

## Sample Output

```
✓ Room data initialized successfully!
✓ Total rooms in inventory: 12

========================================
        AVAILABLE ROOM TYPES
========================================
1. Single Room      - Rs. 1500 per night
2. Double Room      - Rs. 2500 per night
3. Deluxe Room      - Rs. 4000 per night
4. Suite            - Rs. 6000 per night
========================================

========================================
   ALL ROOMS WITH STATIC DATA
========================================
Room ID: 101
Room Type: Single Room
Price per Night: Rs. 1500.0
Status: Available
---------------------------------------------
Room ID: 102
Room Type: Single Room
Price per Night: Rs. 1500.0
Status: Available
---------------------------------------------
[... and so on for all 12 rooms ...]
```

## How to Run

Compile:
```bash
javac RoomUC2.java MainUC2.java
```

Run:
```bash
java MainUC2
```

## Key Concepts

- **Object-Oriented Design**: Room class encapsulation
- **Getter/Setter Methods**: For accessing properties
- **ArrayList**: For storing room objects
- **Static Initialization**: Hard-coded room data
- **Display Methods**: toString() and custom displayDetails()

## Code Structure

```java
MainUC2
├── initializeRooms()     → Creates 12 Room objects
├── displayRoomTypes()    → Shows 4 room types with prices
└── displayAllRooms()     → Lists all rooms with details
```

## Next Steps
- UC3: Add inventory management methods (add, remove, update)
- UC4: Implement room search functionality by type
- UC5: Implement booking functionality
