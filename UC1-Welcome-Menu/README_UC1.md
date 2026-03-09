# UC1 - Application Entry & Welcome Message

## Overview
This use case demonstrates the initial entry point of the Hostel Booking System.

## Features Implemented

### 1. Welcome Screen
- Display a welcoming header when application starts
- Show the application name and tagline
- Create a friendly user interface

### 2. Main Menu
Show 4 options to the user:
1. View Room Types → (Future: UC2)
2. Search Available Rooms → (Future: UC4)
3. Book a Room → (Future: UC5)
4. Exit → Close application

### 3. User Input Handling
- Accept numeric input from user
- Validate menu choices
- Handle invalid inputs gracefully
- Provide error messages for incorrect input

### 4. Menu Loop
- Keep menu running until user selects Exit
- Return to main menu after each operation
- Allow continuous navigation

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
4. Exit
========================================
Enter your choice (1-4): 1

→ View Room Types feature will be implemented in UC2

========================================
           MAIN MENU
========================================
1. View Room Types
2. Search Available Rooms
3. Book a Room
4. Exit
========================================
Enter your choice (1-4): 4

========================================
   Thank you for using our system!
     Safe travels and happy stays!
========================================
```

## How to Run

Compile:
```bash
javac MainUC1.java
```

Run:
```bash
java MainUC1
```

## Key Concepts

- **Scanner Class**: For user input
- **While Loop**: For continuous menu display
- **Switch Statement**: For menu option selection
- **Exception Handling**: For invalid input handling
- **String Formatting**: For attractive UI

## Code Structure

```java
main()
  ├── displayWelcomeScreen()
  └── mainMenu()  [Loop]
      ├── Display Menu
      ├── Accept Input
      └── Handle Choice
          ├── Case 1: View Room Types
          ├── Case 2: Search Available Rooms
          ├── Case 3: Book a Room
          └── Case 4: Exit
```

## Next Steps
- UC2: Add Room class with room types
- UC3: Create inventory management
- UC4: Implement room search functionality
