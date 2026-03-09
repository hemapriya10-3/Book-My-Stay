# UC6 - Reservation Confirmation & Room Allocation

## Overview
This use case implements reservation confirmation with automatic room allocation to customers.

## Features Implemented

### 1. Reservation Confirmation
- Verify room availability
- Auto-generate unique Reservation ID (starting from 5001)
- Create confirmed reservation
- Mark room as allocated (unavailable)

### 2. Reservation Details Displayed
- **Reservation ID**: Auto-generated (5001, 5002, etc.)
- **Customer Name**: User's provided name
- **Room Type**: Category (Single, Double, Deluxe, Suite)
- **Room ID**: Specific room number
- **Check-in Date**: User-provided DD-MM-YYYY
- **Check-out Date**: User-provided DD-MM-YYYY
- **Room Price**: Price per night
- **Total Price**: Booking total
- **Confirmation Status**: CONFIRMED
- **Confirmation Time**: Timestamp of booking

### 3. Room Allocation
- Mark room as unavailable after confirmation
- Only available rooms can be booked
- Room remains allocated until cancellation
- Cannot double-book same room

### 4. Reservation Management
- Store all confirmed reservations
- Cancel reservations and free up rooms
- View all reservations
- Search reservation by ID
- Display occupancy statistics

## Sample Output

```
╔════════════════════════════════════════╗
║ UC6 - RESERVATION CONFIRMATION SYSTEM ║
╚════════════════════════════════════════╝

========================================
    RESERVATION SYSTEM MENU
========================================
1. Confirm New Reservation
2. View All Reservations
3. View Reservation Details
4. Cancel Reservation
5. View Available Rooms
6. View Occupancy Statistics
7. Exit
========================================
Enter your choice (1-7): 1

========================================
     CONFIRM RESERVATION
========================================
Enter Customer Name: Rajesh Kumar
Enter Room ID: 201
Enter Check-in Date (DD-MM-YYYY): 15-03-2026
Enter Check-out Date (DD-MM-YYYY): 18-03-2026

╔════════════════════════════════════════╗
║    RESERVATION CONFIRMATION            ║
╚════════════════════════════════════════╝

  Reservation ID....... : 05001
  Customer Name........ : Rajesh Kumar
  Room Type............ : Double Room
  Room ID.............. : 201
  Room Price........... : Rs. 2500.00 per night
  Check-in Date........ : 15-03-2026
  Check-out Date....... : 18-03-2026
  Total Price.......... : Rs. 2500.00
  Status............... : CONFIRMED
  Confirmed At......... : 2026-03-09T14:30:45.123456789

  ✓ Room has been allocated to you!
  ✓ Please save your Reservation ID!
  ✓ Thank you for booking with us!

╚════════════════════════════════════════╝

========================================
    RESERVATION SYSTEM MENU
========================================
...
Enter your choice (1-7): 2

========================================
    ALL CONFIRMED RESERVATIONS
========================================
Total Reservations: 1

Reservation ID: 05001
Customer: Rajesh Kumar
Room Type: Double Room (ID: 201)
Check-in: 15-03-2026 → Check-out: 18-03-2026
Price: Rs. 2500.00
Status: CONFIRMED
---------------------------------------------

========================================

========================================
    RESERVATION SYSTEM MENU
========================================
...
Enter your choice (1-7): 3

========================================
    VIEW RESERVATION DETAILS
========================================
Enter Reservation ID: 5001

========================================
    RESERVATION DETAILS
========================================
Reservation ID: 05001
Customer Name: Rajesh Kumar
Room Type: Double Room
Room ID: 201
Check-in Date: 15-03-2026
Check-out Date: 18-03-2026
Room Price: Rs. 2500.00 per night
Total Price: Rs. 2500.00
Status: CONFIRMED
Confirmed At: 2026-03-09T14:30:45.123456789
========================================

========================================
    RESERVATION SYSTEM MENU
========================================
...
Enter your choice (1-7): 6

========================================
    OCCUPANCY STATISTICS
========================================
Total Rooms: 12
Available Rooms: 7
Booked Rooms: 5
Confirmed Reservations: 1
Occupancy Rate: 41.7%
========================================
```

## Reservation ID Generation

```java
private static int reservationCounter = 5000;
// First reservation: 5001
// Second: 5002
// And so on...
```

- Starts at 5000
- Auto-incremented for each reservation
- Unique identifier for each booking

## Room Allocation Process

```
User Requests Reservation
        ↓
[Find Room by ID]
        ↓ Room not found → Return null
[Check Room Availability]
        ↓ Not available → Return null
[Create Reservation Object]
        ↓ (Auto-generates ID 5001+)
[Mark Room as Unavailable]
        ↓ (setAvailability(false))
[Store in confirmedReservations]
        ↓
Display Confirmation
```

## Code Structure

```
ReservationManagementUC6
├── initializeRooms()              → Init 12 rooms
├── confirmReservation()           → Confirm & allocate
├── cancelReservation()            → Cancel & release room
├── getReservationById()           → Find reservation
├── getRoomById()                  → Find room
├── displayAllReservations()       → Show all
├── displayOccupancyStats()        → Show statistics
└── getAllRooms()                  → Get rooms

ReservationUC6
├── Auto-increment reservationId
├── displayConfirmation()          → Formatted confirmation
├── displayDetails()               → List format details
└── toString()                     → String representation

MainUC6
├── main()                         → Entry point
├── reservationMenu()              → Interactive menu
├── confirmNewReservation()        → Confirmation process
├── viewReservationDetails()       → View details
├── cancelReservation()            → Cancel process
└── displayAvailableRooms()        → Show vacancies
```

## How to Run

Compile:
```bash
javac RoomUC6.java ReservationUC6.java ReservationManagementUC6.java MainUC6.java
```

Run:
```bash
java MainUC6
```

## Key Features

✅ **Auto-generated Reservation IDs** - Sequential 5001+
✅ **Room Allocation** - Automatic marking of booked rooms
✅ **Confirmation Display** - Formatted receipt-like output
✅ **Timestamp** - Records confirmation time
✅ **Cancellation** - Releases room back to inventory
✅ **Occupancy Tracking** - Real-time statistics
✅ **Search Capability** - Find reservation by ID

## Confirmation Details

The confirmation displays:
1. **Reservation ID** - Unique booking reference
2. **Customer Name** - Who made the booking
3. **Room Type** - Category of room (Single/Double/etc)
4. **Room ID** - Specific room number
5. **Check-in Date** - Arrival date
6. **Check-out Date** - Departure date
7. **Room Price** - Per night rate
8. **Total Price** - Total booking cost
9. **Status** - CONFIRMED
10. **Confirmation Time** - Booking timestamp

## Cancellation Process

When reservation is cancelled:
1. Find reservation by ID
2. Get associated room ID
3. Change room availability to true
4. Remove from confirmedReservations
5. Display cancellation confirmation
6. Room becomes available again

## Next Steps
- Enhancement: Calculate total price based on number of nights
- Enhancement: Payment processing
- Enhancement: Guest check-in/check-out system
- Enhancement: Review and rating system
- Enhancement: Database persistence
