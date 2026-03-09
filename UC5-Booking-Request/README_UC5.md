# UC5 - Booking Request

## Overview
This use case implements booking request functionality with comprehensive validation.

## Features Implemented

### 1. User Input for Booking
```
Customer Name:        Text input
Room ID:             Numeric input
Check-in Date:       DD-MM-YYYY format
Check-out Date:      DD-MM-YYYY format
```

### 2. Validations Performed

#### Customer Name Validation
- ✓ Cannot be empty
- ✓ Minimum 3 characters
- ✓ Case-insensitive

#### Date Format Validation
- ✓ Check-in must be DD-MM-YYYY format
- ✓ Check-out must be DD-MM-YYYY format
- ✓ Regex pattern: `\d{2}-\d{2}-\d{4}`

#### Date Logic Validation
- ✓ Check-out date must be after check-in date
- ✓ Cannot be same day
- ✓ Parses and compares dates numerically

#### Room Validation
- ✓ Room ID must exist in system
- ✓ Room must be available for booking
- ✓ Cannot book already reserved room

### 3. Booking Request Class
```java
BookingUC5
├── customerName (String)
├── roomId (int)
├── checkInDate (String)
├── checkOutDate (String)
├── roomPrice (double)
├── isValidated (boolean)
└── validationMessage (String)
```

### 4. Validation Methods
- validateCustomerName()
- validateDateFormat()
- validateDateLogic()
- validateRoomAvailability()

## Sample Output

```
╔════════════════════════════════════════╗
║     UC5 - BOOKING REQUEST SYSTEM     ║
╚════════════════════════════════════════╝

========================================
       BOOKING REQUEST MENU
========================================
1. Create New Booking Request
2. View Available Rooms
3. View All Booking Requests
4. View Validated Requests
5. Exit
========================================
Enter your choice (1-5): 1

========================================
     CREATE BOOKING REQUEST
========================================
Enter Customer Name: Rajesh Kumar
Enter Room ID: 201
Enter Check-in Date (DD-MM-YYYY): 15-03-2026
Enter Check-out Date (DD-MM-YYYY): 18-03-2026

========================================
       BOOKING REQUEST DETAILS
========================================
Customer Name: Rajesh Kumar
Room ID: 201
Check-in Date: 15-03-2026
Check-out Date: 18-03-2026
Room Price: Rs. 2500.0 per night
Status: ✓ Validated
========================================

========================================
      VALIDATING BOOKING REQUEST
========================================
✓ Customer name validated
✓ Date format validated
✓ Date logic validated
✓ Room exists
✓ Room is available
========================================
✓ ALL VALIDATIONS PASSED!
========================================

✓ Booking request saved for confirmation!

========================================
       BOOKING REQUEST MENU
========================================
...
Enter your choice (1-5): 2

========================================
       AVAILABLE ROOMS
========================================
ID: 101 | Type: Single Room | Price: Rs. 1500.0
ID: 102 | Type: Single Room | Price: Rs. 1500.0
ID: 201 | Type: Double Room | Price: Rs. 2500.0
ID: 202 | Type: Double Room | Price: Rs. 2500.0
ID: 301 | Type: Deluxe Room | Price: Rs. 4000.0
ID: 302 | Type: Deluxe Room | Price: Rs. 4000.0
ID: 401 | Type: Suite | Price: Rs. 6000.0
ID: 403 | Type: Suite | Price: Rs. 6000.0

Total Available: 8
========================================

========================================
       BOOKING REQUEST MENU
========================================
...
Enter your choice (1-5): 4

========================================
   VALIDATED BOOKING REQUESTS
========================================

Request #1
Customer: Rajesh Kumar
Room ID: 201
Check-in: 15-03-2026
Check-out: 18-03-2026
Room Price: Rs. 2500.0 per night
Status: ✓ Validated and Ready for Confirmation
---------------------------------------------

========================================
```

## Validation Error Examples

```
Error 1: Empty Customer Name
✗ Customer name cannot be empty!

Error 2: Short Name
✗ Customer name must be at least 3 characters!

Error 3: Invalid Date Format
✗ Check-in date must be in format DD-MM-YYYY!

Error 4: Invalid Check-out Date
✗ Check-out date must be after check-in date!

Error 5: Room Not Found
✗ Room ID 999 not found!

Error 6: Room Not Available
✗ Room 101 is not available!
```

## Code Structure

```
BookingManagementUC5
├── initializeRooms()              → Init 12 rooms
├── createBookingRequest()         → Create request object
├── validateBookingRequest()       → Full validation
├── storeBookingRequest()          → Save validated request
├── getRoomById()                  → Find room
├── displayAllBookingRequests()    → Show all requests
├── getValidatedBookingRequests()  → Filter validated only
└── getAllRooms()                  → Get all rooms

BookingUC5
├── validateCustomerName()         → Name validation
├── validateDateFormat()           → Date format check
├── validateDateLogic()            → Date comparison
├── displayBookingRequest()        → Format display
└── toString()                     → String representation

MainUC5
├── main()                         → Entry point
├── bookingMenu()                  → Interactive menu
├── createBookingRequest()         → Booking process
├── displayAvailableRooms()        → Show vacancies
└── displayValidatedRequests()     → Show valid bookings
```

## How to Run

Compile:
```bash
javac RoomUC5.java BookingUC5.java BookingManagementUC5.java MainUC5.java
```

Run:
```bash
java MainUC5
```

## Key Concepts

- **Input Validation**: Multi-step validation process
- **Date Parsing**: Convert and compare date strings
- **Regex Patterns**: Validate date format
- **Error Handling**: Graceful error messages
- **Request Storage**: ArrayList-based persistence
- **Separation of Concerns**: Management & Entity classes

## Date Validation Logic

```java
// Parse dates
DD = substring(0, 2)
MM = substring(3, 5)
YYYY = substring(6, 10)

// Compare
checkOutTime = YYYY*10000 + MM*100 + DD
checkInTime = YYYY*10000 + MM*100 + DD

if (checkOutTime <= checkInTime)
    return false // Invalid
```

## Validation Sequence

```
User Input
    ↓
[Create BookingRequest Object]
    ↓
[Validate Customer Name]
    ↓ (if fail) → Display Error
[Validate Date Format]
    ↓ (if fail) → Display Error
[Validate Date Logic]
    ↓ (if fail) → Display Error
[Validate Room Exists]
    ↓ (if fail) → Display Error
[Validate Room Available]
    ↓ (if fail) → Display Error
[All Passed]
    ↓
Store Validated Request
```

## Next Steps
- UC6: Confirm validated requests and allocate rooms
- Enhancement: Calculate total booking cost (nights * price)
- Enhancement: Add cancellation fee policy
- Enhancement: Database persistence for requests
