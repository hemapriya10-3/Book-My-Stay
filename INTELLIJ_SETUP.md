# IntelliJ IDEA Setup Instructions

## Method 1: Import Existing Project (RECOMMENDED)

### Step 1: Open IntelliJ IDEA
1. Launch IntelliJ IDEA
2. Click **File → Open**
3. Navigate to: `c:\Users\vjk51\Desktop\step\HostelBooking`
4. Click **OK**

### Step 2: Configure as Java Project
- IntelliJ should auto-detect the Java project structure
- If prompted, click **Mark Directory as → Sources root** for the `src` folder

### Step 3: Verify Java SDK
1. Click **File → Project Structure** (Ctrl + Alt + Shift + S)
2. Select **Project**
3. Verify **SDK** is set to Java 8, 11, 17, or 21
4. If not, click **Edit** and select your installed JDK
5. Click **OK**

### Step 4: Mark Source Folder
1. Right-click **src** folder
2. Select **Mark Directory as → Sources Root**

### Step 5: Run the Application
1. Open **src/com/hostel/Main.java**
2. Click the green ▶ play button (top-right of editor window)
3. Or press **Shift + F10**
4. Application runs in the console

---

## Method 2: Create New Project (ALTERNATIVE)

### Step 1: Create New Java Project
1. **File → New → Project**
2. Select **Java** (left panel)
3. Click **Next**

### Step 2: Configure Project
1. **Project name**: HostelBooking
2. **Project location**: `c:\Users\vjk51\Desktop\step\HostelBooking`
3. **Create git repository**: Optional (can enable for version control)
4. Click **Create**

### Step 3: Create Package Structure
1. Right-click **src**
2. **New → Package**
3. Name: `com.hostel`
4. Click **OK**

5. Repeat:
   - Package: `com.hostel.entities`
   - Package: `com.hostel.management`

### Step 4: Add Java Files
1. Right-click package `com.hostel`
2. **New → Java Class**
3. Name: `Main`
4. Copy provided code into the file

5. Repeat for:
   - `com.hostel.entities.Room`
   - `com.hostel.entities.Booking`
   - `com.hostel.management.HotelManagement`

### Step 5: Run
- Right-click **Main.java** → **Run 'Main.main()'**

---

## Project Structure Verification

After setup, your project should look like:

```
HostelBooking (Project Root)
├── .idea/                          (IntelliJ configuration - auto created)
├── src/
│   └── com/
│       └── hostel/
│           ├── Main.java           ✓
│           ├── entities/
│           │   ├── Room.java       ✓
│           │   └── Booking.java    ✓
│           └── management/
│               └── HotelManagement.java ✓
├── README.md                      ✓
├── TESTING_GUIDE.md              ✓
├── IMPLEMENTATION_SUMMARY.md     ✓
└── INNELJJ_SETUP.md             ✓ (This file)
```

---

## Keyboard Shortcuts (Windows)

| Action | Shortcut |
|--------|----------|
| Run Program | Shift + F10 |
| Run → Run... | Alt + Shift + F10 |
| Stop Program | Ctrl + F2 |
| Compile | Ctrl + F9 |
| Search Everywhere | Double Shift |
| Go to Class | Ctrl + N |
| Find in File | Ctrl + F |
| Format Code | Ctrl + Alt + L |

---

## Troubleshooting

### Issue: "Project SDK is not defined"
**Solution:**
1. File → Project Structure
2. Click on **Project** (left panel)
3. Set SDK dropdown to your Java version
4. Click OK

### Issue: "Cannot find symbol: class Room"
**Solution:**
1. Right-click `src` folder
2. Select **Mark Directory as → Sources Root**
3. Wait for IntelliJ to re-index (watch bottom bar)

### Issue: "main() method not found"
**Solution:**
1. Ensure Main.java is in `com.hostel` package (not `com.hostel.entities` or `.management`)
2. Main class must have declaration:
   ```java
   public static void main(String[] args)
   ```

### Issue: Scanner not importing
**Solution:**
- Make sure you have:
  ```java
  import java.util.Scanner;
  ```
- IntelliJ usually auto-imports (Ctrl + Space for autocomplete)

### Issue: Running but no input prompt appears
**Solution:**
1. Check IDE console (bottom of screen)
2. If console is hidden: View → Tool Windows → Debug → Console
3. Type your input in the console

---

## Run Configurations

### View/Create Run Configuration:
1. **Run → Edit Configurations...**
2. Click **+** to add new configuration
3. Select **Application**
4. Fill in:
   - **Name**: HostelBooking
   - **Main class**: `com.hostel.Main`
   - **Working directory**: Project root
5. Click **OK**
6. Click **Run** (or Shift + F10)

---

## Console Input/Output Tips

- **Type directly** in the console when prompted
- **Press Enter** after each input
- **Output displays immediately** above
- **Colors** can be customized: Settings → Editor → Color Scheme

---

## Common Maven/Gradle (Not needed for this project)

This project does **NOT** use Maven or Gradle - it's pure Java.
No `pom.xml` or `build.gradle` needed.

---

## Building JAR (Optional)

To create executable JAR:

1. **File → Project Structure → Artifacts**
2. Click **+** → **JAR → From modules with dependencies**
3. Select **Main.java** as Main Class
4. Click **OK**
5. **Build → Build Artifacts → HostelBooking.jar → Build**

JAR will be in `out/artifacts/` directory.

To run: `java -jar HostelBooking.jar`

---

## Quick Start Checklist

- [ ] Opened project in IntelliJ IDEA
- [ ] Verified Java SDK is set (Java 8+)
- [ ] All 4 Java files present in correct packages
- [ ] Marked `src` as Sources Root
- [ ] Opened Main.java
- [ ] Clicked green Play button or pressed Shift + F10
- [ ] Welcome screen appeared
- [ ] Tested menu option 1
- [ ] Booking system working ✓

---

## Support Files

- **README.md** - Complete project documentation
- **TESTING_GUIDE.md** - Test scenarios and sample inputs
- **IMPLEMENTATION_SUMMARY.md** - Technical details and architecture

---

**Status**: Ready to Import and Run ✅

All Java files are ready to use. Simply open in IntelliJ and hit Run!
