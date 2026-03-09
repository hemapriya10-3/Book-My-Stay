# Git Setup Guide for Use Cases

## Project Structure

Each use case is organized in a separate directory with independent implementations:

```
HostelBooking/
├── UC1-Welcome-Menu/
│   ├── MainUC1.java
│   └── README_UC1.md
│
├── UC2-RoomTypes-Static/
│   ├── RoomUC2.java
│   ├── MainUC2.java
│   └── README_UC2.md
│
├── UC3-Inventory-Management/
│   ├── RoomUC3.java
│   ├── InventoryManagementUC3.java
│   ├── MainUC3.java
│   └── README_UC3.md
│
├── UC4-Room-Search/
│   ├── RoomUC4.java
│   ├── SearchManagementUC4.java
│   ├── MainUC4.java
│   └── README_UC4.md
│
├── src/
│   └── com/hostel/      (Complete implementation)
│
└── GIT_SETUP.md         (This file)
```

## Creating Git Branches for Each Use Case

### Step 1: Initialize Git Repository

```bash
cd c:\Users\vjk51\Desktop\step\HostelBooking
git init
git config user.name "Your Name"
git config user.email "your.email@example.com"
```

### Step 2: Create and Commit Main Branch

```bash
# Initial commit with all files
git add .
git commit -m "Initial commit: Complete Hostel Booking System with UC1-UC6"
```

### Step 3: Create Branch for UC1

```bash
# Create new branch from main/master
git checkout -b uc1-welcome-menu

# Add only UC1 files
git add UC1-Welcome-Menu/

# Create a fresh commit with just UC1
git commit -m "UC1: Application Entry & Welcome Message

- Welcome screen implementation
- Main menu with 4 options
- User input handling
- Menu loop with exit functionality"

# Push to remote
git push origin uc1-welcome-menu
```

### Step 4: Create Branch for UC2

```bash
# Go back to main branch
git checkout main  # or master

# Create UC2 branch
git checkout -b uc2-room-types-static

# Add UC2 files with UC1 as dependency
git add UC1-Welcome-Menu/
git add UC2-RoomTypes-Static/

git commit -m "UC2: Basic Room Types & Static Availability

- Room class with 4 room types
- Static room data initialization
- Room properties: ID, Type, Price, Availability
- Room type and detail display methods"

git push origin uc2-room-types-static
```

### Step 5: Create Branch for UC3

```bash
git checkout main

git checkout -b uc3-inventory-management

# Include UC1, UC2, and UC3
git add UC1-Welcome-Menu/
git add UC2-RoomTypes-Static/
git add UC3-Inventory-Management/

git commit -m "UC3: Centralized Room Inventory Management

- ArrayList-based room inventory
- Add/Remove room operations
- Update availability functionality
- Display all rooms with statistics
- Iterator-based safe removal"

git push origin uc3-inventory-management
```

### Step 6: Create Branch for UC4

```bash
git checkout main

git checkout -b uc4-room-search

# Include UC1, UC2, UC3, and UC4
git add UC1-Welcome-Menu/
git add UC2-RoomTypes-Static/
git add UC3-Inventory-Management/
git add UC4-Room-Search/

git commit -m "UC4: Room Search & Availability Check

- Search rooms by type
- Search available rooms by type
- Individual room availability check
- Display available rooms with details
- Search statistics and metrics"

git push origin uc4-room-search
```

### Step 7: Create Branch for UC5

```bash
git checkout main

git checkout -b uc5-booking-request

# Include UC1 through UC5
git add UC1-Welcome-Menu/
git add UC2-RoomTypes-Static/
git add UC3-Inventory-Management/
git add UC4-Room-Search/
git add UC5-Booking-Request/

git commit -m "UC5: Booking Request

- Create booking request with customer input
- Validate customer name (3+ characters)
- Validate date format (DD-MM-YYYY)
- Validate date logic (checkout after checkin)
- Validate room existence and availability
- Store validated booking requests"

git push origin uc5-booking-request
```

### Step 8: Create Branch for UC6

```bash
git checkout main

git checkout -b uc6-reservation-confirmation

# Include all UC1 through UC6
git add UC1-Welcome-Menu/
git add UC2-RoomTypes-Static/
git add UC3-Inventory-Management/
git add UC4-Room-Search/
git add UC5-Booking-Request/
git add UC6-Reservation-Confirmation/

git commit -m "UC6: Reservation Confirmation & Room Allocation

- Confirm reservation if room available
- Auto-generate Reservation ID (5001+)
- Allocate room to customer (mark unavailable)
- Display confirmation with all details
- Support cancellation and room release
- Track occupancy statistics"

git push origin uc6-reservation-confirmation
```

## View Branches

```bash
# List all local branches
git branch

# List all remote branches
git branch -r

# List all branches (local and remote)
UC5:  https://github.com/YOUR_USERNAME/HostelBooking/tree/uc5-booking-request
UC6:  https://github.com/YOUR_USERNAME/HostelBooking/tree/uc6-reservation-confirmation
git branch -a
```

## Switch Between Branches

```bash
# Switch to UC1 branch
git checkout uc1-welcome-menu

# Switch to UC2 branch
git checkout uc2-room-types-static

# Switch to UC3 branch
git checkout uc3-inventory-management

# Switch to UC4 branch
git checkout uc4-room-search

# Switch back to main
git checkout main
```

## Branch Dependency Flow

```
main
  ├── uc1-welcome-menu
  │   └── Main menu structure
  │
  ├── uc2-room-types-static
  │   ├── Includes UC1
  │   └── Room class & static data
  │
  ├── uc3-inventory-management
  │   ├── Includes UC1 + UC2
  ├── uc4-room-search
  │   ├── Includes UC1 + UC2 + UC3
  │   └── Search functionality
  │
  ├── uc5-booking-request
  │   ├── Includes UC1 + UC2 + UC3 + UC4
  │   └── Booking validation
  │
  └── uc6-reservation-confirmation
      ├── Includes UC1 + UC2 + UC3 + UC4 + UC5
      └── Reservation & room allocation
      ├── Includes UC1 + UC2 + UC3
      └── Search functionality
```

## Repository Links

After pushing to GitHub, you'll have separate links for each use case:

```
Main: https://github.com/YOUR_USERNAME/HostelBooking

UC1:  https://github.com/YOUR_USERNAME/HostelBooking/tree/uc1-welcome-menu
UC2:  https://github.com/YOUR_USERNAME/HostelBooking/tree/uc2-room-types-static
UC3:  https://github.com/YOUR_USERNAME/HostelBooking/tree/uc3-inventory-management
UC4:  https://github.com/YOUR_USERNAME/HostelBooking/tree/uc4-room-search
```

## Push All Branches

```bash
# Push all branches to remote
git push origin --all

# Push aall use cases
git merge uc1-welcome-menu
git merge uc2-room-types-static
git merge uc3-inventory-management
git merge uc4-room-search
git merge uc5-booking-request
git merge uc6-reservation-confirmation

# Resolve any conflicts if they occur
# Then commit the merge
git commit -m "Merge all use case branches (UC1-UC6) into main"
```

## Create Release Tags

```bash
# Create tag for UC1 release
git tag -a v1.0-uc1 uc1-welcome-menu -m "UC1 Release: Welcome Menu"
git push origin v1.0-uc1

# Create tag for UC2 release
git tag -a v1.1-uc2 uc2-room-types-static -m "UC2 Release: Room Types"
git push origin v1.1-uc2

# Create tag for UC3 release
git tag -a v1.2-uc3 uc3-inventory-management -m "UC3 Release: Inventory"
git push origin v1.2-uc3

# Create tag for UC4 release
git tag -a v1.3-uc4 uc4-room-search -m "UC4 Release: Search"
git push origin v1.3-uc4

# Create tag for UC5 release
git tag -a v1.4-uc5 uc5-booking-request -m "UC5 Release: Booking Request"
git push origin v1.4-uc5

# Create tag for UC6 release
git tag -a v1.5-uc6 uc6-reservation-confirmation -m "UC6 Release: Reservation Confirmation"
git push origin v1.5-uc6

# Create final release tag
git tag -a v2.0-complete main -m "Complete Hostel Booking System (UC1-UC6)"
git push origin v2.0-completeease
git tag -a v1.1-uc2 uc2-room-types-static -m "UC2 Release: Room Types"
git push origin v1.1-uc2

# Create tag for UC3 release
git tag -a v1.2-uc3 uc3-inventory-management -m "UC3 Release: Inventory"
git push origin v1.2-uc3

# Create tag for UC4 release
git tag -a v1.3-uc4 uc4-room-search -m "UC4 Release: Search"
git push origin v1.3-uc4
```

## GitHub Setup Instructions

### Create Repository on GitHub

1. Go to github.com
2. Click "New" to create new repository
3. Name: `HostelBooking`
4. Add description: "Hostel Booking System - Java Implementation"
5. Choose public/private
6. Click "Create repository"

### Connect Local to Remote

```bash
# Add remote repository
git remote add origin https://github.com/YOUR_USERNAME/HostelBooking.git

# Verify remote
git remote -v

# Push initial commit
git push -u origin main
```

## Recommended Commit Messages

```
UC1 Commit:
git commit -m "UC1: Application Entry & Welcome Message

- Welcome screen display
- Main menu implementation  
- User input validation
- Program exit handling"

UC2 Commit:
git commit -m "UC2: Basic Room Types & Static Availability

- Room entity class
- 4 room types definition
- Static data initialization
- Display methods"

UC5 Commit:
git commit -m "UC5: Booking Request

- User input: Name, Room ID, Dates
- Customer name validation (3+ chars)
- Date format validation (DD-MM-YYYY)
- Date logic validation (checkout > checkin)
- Room existence and availability check
- Store validated requests in ArrayList"

UC6 Commit:
git commit -m "UC6: Reservation Confirmation & Room Allocation

- Confirm reservation if room available
- Auto-generate Reservation IDs (5001+)
- Allocate room (mark unavailable)
- Display confirmation with all details
- Support cancellation and room release
- Occupancy statistics and tracking"

UC3 Commit:
git commit -m "UC3: Centralized Room Inventory Management

- ArrayList-based inventory
- Add/Remove/Update operations
- Room details display
- Inventory statistics"

UC4 Commit:
git commit -m "UC4: Room Search & Availability Check

- Search by room type
- Search by availability
- Display available rooms
- Room status checking"
```

## Branch Protection Rules (Optional)

```bash
# Create a .gitignore file
echo "*.class" > .gitignore
echo "*.jar" >> .gitignore
echo ".idea/" >> .gitignore
echo "*.iml" >> .gitignore
echo "out/" >> .gitignore

git add .gitignore
git commit -m "Add .gitignore"
```

## View Commit History

```bash
# View all commits
git log

# View commits with graph
git log --oneline --graph --all

# View commits for specific branch
git log uc1-welcome-menu
```

## Useful Git Commands Summary

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/HostelBooking.git

# Check status
git status

# Add files
git add .
git add UC1-Welcome-Menu/

# Commit changes
git commit -m "Your message"

# Push to remote
git push origin branch-name

# Pull from remote
git pull origin branch-name

# Create new branch
git checkout -b new-branch-name

# Delete local branch
git branch -d branch-name

# Delete remote branch
git push origin --delete branch-name
```

## CI/CD Integration (Optional)

Add GitHub Actions workflow file `.github/workflows/java.yml`:

```yaml
name: Java Build

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK
        uses: actions/setup-java@v2
        with:
          java-version: '11'
      - name: Compile UC1
        run: javac UC1-Welcome-Menu/*.java
      - name: Compile UC2
        run: javac UC2-RoomTypes-Static/*.java
      - name: Compile UC3
        run: javac UC3-Inventory-Management/*.java
      - name: Compile UC4
        run: javac UC4-Room-Search/*.java
```

## Summary

✅ **Main Branch**: Contains complete implementation with all UCs (1-6)
✅ **UC1 Branch**: Welcome screen only
✅ **UC2 Branch**: Includes UC1 + Room types
✅ **UC3 Branch**: Includes UC1+UC2 + Inventory management
✅ **UC4 Branch**: Includes UC1+UC2+UC3 + Search functionality
✅ **UC5 Branch**: Includes UC1+UC2+UC3+UC4 + Booking validation
✅ **UC6 Branch**: Includes UC1+UC2+UC3+UC4+UC5 + Reservation confirmation

Each branch can be accessed via separate GitHub links!

---

**Ready to push to Git!** 🚀
