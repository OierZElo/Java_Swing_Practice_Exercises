✈️ Programming III Exam - Engineering - University of Deusto

Exam: Programming III - November 2023 Time Limit: 2.5 hours

📜 Instructions

    The exam base is available on ALUD. Download the ZIP, unzip it, and create an Eclipse project with the provided folder structure. Work in an easily locatable path (e.g., Desktop).

    To submit your answer via ALUD, compress the root folder of the Eclipse project, ensure all edited files are included, and upload it to the ALUD task.

    The exam focuses on two course competencies:

        CE-01: Building complex graphical interfaces, customizing the behavior and visual appearance of standard Java Swing components.

        CE-02: Designing and handling data structures based on Java Collections and Generics.

    Final Application Behavior: After implementing all tasks, you'll be able to see the plane seat occupancy. By pressing CTRL + C, a dialog will open allowing you to search for and check-in multiple seats of the same class.

✅ Tasks

T1. Create a Data Model for a JTable [2 points]

    Target: Create a new class (40-50 lines) and load this model into JFrameCheckIn.java.

Objective: Create a custom data model to display seat information row by row in the seatsTable JTable.

Requirements:

    The table should display the airplane seats, assuming 38 rows with 6 seats each (A to F).

    The model must return information in 8 columns:

        Column 0 (Integer): Row number (1 to 38).

        Columns 1-3 (Seat): Seats A to C.

        Column 4 (Empty String): Empty column to simulate the aisle.

        Columns 5-7 (Seat): Seats D to F.

    The model's constructor must receive a list List<Seat> of all seats for initialization.

    Table row 0 corresponds to airplane row 1, and so on.

    All cells must be non-editable.

    Define headers as follows: 1, A, B, C, (empty), D, E, F.

T2. Implement a Custom Renderer for a JTable [2 points]

    Target: JFrameCheckIn.java (50-60 lines)

Objective: Modify the table rendering to visualize seat data as shown in the reference image.

Requirements:

    Header: The letter columns (A, B, C, D, E, F) must show the letter images (resources/images/A.png, etc.) with a background color of RGB(237, 237, 237).

    The 1st and 4th header columns must appear empty with the table's default background color.

    Data Columns:

        The 1st data column (row numbers) must have the default background color.

        Seats in FIRST_CLASS rows must have a custom background: RGB(245, 247, 220).

        Seats in EMERGENCY rows must have a custom background: RGB(252, 191, 183).

        Each seat cell must display the appropriate image: Occupied.png or Available.png.

        Column 4 (aisle) must appear empty with the table's default background color.

    The default height for all table rows must be 32 pixels.

T3. Implement a Keyboard Event [1 point + 1 extra]

    Target: JFrameCheckIn.java (10 lines)

Objective: Open the JDialogSeatAllocator dialog when a specific key combination is pressed.

Requirements:

    When the key combination CTRL + C is pressed while the table has focus, open the JDialogSeatAllocator to search for and confirm seats (calling its constructor is sufficient).

Extra. Force Component Repainting [1 point]

    Target: JDialogSeatAllocator.java (5 lines)

Objective: Automatically update the seat occupancy in the main table after a reservation is confirmed in the dialog.

Requirements:

    Add the necessary code to the dialog so that every time a seat suggestion is confirmed, the main table is automatically repainted.

T4. Initialize a Map from a List [1 point]

    Target: SeatAllocator.java (10 lines)

Objective: Create a map to group seats by row number.

Requirements:

    From the list of seats (List<Seat> seats), create the map Map<Integer, List<Seat>> that groups the seats by row number. This map will be used as an auxiliary data structure for finding recommended seats.

T5. Create a Complex Data Structure from Another [2.5 points]

    Target: SeatAllocator.java (35-40 lines)

Objective: Create a list containing lists of contiguous (unoccupied) seats within the same row, based on seat class and quantity needed.

Requirements:

    Process seats in each row (using the seatsMap from T4) to group free seats that are contiguous.

    Save only those groups whose size is greater than or equal to the number of required seats.

    Contiguity Rule: Seats in each row are ordered A to F. Aisle seats (C and D) are considered contiguous.

    If no seat group meets the required class and number of seats, the returned list must be empty.

    Example: If 2 FIRST_CLASS seats are requested, return [[1C,1D], [2C,2D], ...].

T6. Sort a List using 2 Criteria [1.5 points]

    Target: SeatAllocator.java (10-15 lines)

Objective: Sort a list of seat lists (List<List<Seat>>) using two specific criteria.

Criteria:

    Primary: Sort by the number of seats in the list (ascending).

    Secondary: If the number of seats is the same, sort by the row number of the seats (descending).
