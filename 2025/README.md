♟️ Programming III: Partial Exam (Java)

Course: 2025/2026 Date: November 7, 2025 Total Score: 10 points (Duration: 2.5h)

📜 Instructions

    Before starting the exam, you must follow the steps indicated in the instructions sheet.

    This exam focuses on a chess championship management application.

    For each task, the score, the class where the code should be added, and an estimated number of lines of code are indicated.

    The provided base code is organized into several packages, each related to a specific competence and containing a main() method for independent testing.

🎯 Competence CE-1: Graphical Interfaces with Swing [6 points]

Task 1.1: Layouts [2 points]

    Class: VentanaEmparejamientos

    Estimate: 85 lines

Objective: Develop a window to visualize the chess pairings in the championship. When the user selects a day from the JList, the window must display the data of the participants facing each other on that day, as shown in the image reference.

Key Requirements:

    Implement this exercise using basic components and layouts (GridLayout, FlowLayout, BorderLayout).

    Players facing each other on the same day must appear in the same row, with the time of the match indicated in the title.

    The cargarImagen method is available to load the profile image and scale it.

    The maximum number of matches on the same day is 3. If a day has fewer than 3 matches, you must fill the available slots with empty panels.

    (Video reference available in resources/doc)

Task 1.2: Data Model [1.5 points]

    Class: VentanaTablero

    Estimate: 60 lines

Objective: Implement a data model so that the JTable can use the data contained in the matrix PiezasAjedrez[][] tablero, which represents the state of the chessboard and is already initialized with test data.

Requirements:

    Labels (coordinates) referencing a specific cell on the board must appear on the top and bottom (letters), as well as on both sides (numbers) of the board.

    The symbol for each chess piece is represented by a String with a Unicode symbol.

    (Image reference for an intermediate result is available in the original prompt)

Task 1.3: Table Rendering [1.5 points]

    Class: VentanaTablero

    Estimate: 60 lines

Objective: Achieve the final visual appearance of the table as shown in the image reference.

Requirements:

    This task must be possible even if the data model (Task 1.2) could not be implemented (by directly using the tablero matrix data).

    Each PiezaAjedrez contains the path to the corresponding image.

    Colors used for the squares:

        Dark: (120, 151, 88)

        Light: (239, 238, 211)

Task 1.4: Events [1 point]

    Class: VentanaTablero

    Estimate: 10 lines

Objective: Implement mouse click functionality on the board.

Requirements:

    When the user clicks the mouse on a cell, a white pawn must be added to that cell on the board.

    (Video reference available in resources/doc)

⚡ Competence CE-2: Threads [4 points]

Task 1.5 Threads [4 points]

    Class: VentanaJuego

    Estimate: 60 lines

Objective: Complete a mini-game where the user must "hunt" a pawn that moves randomly across a board within a determined time limit.

Concurrency and Logic Requirements:

    The game does not start until the user clicks the "Iniciar" (Start) button.

    The pawn must move randomly across the board, remaining in each position for 500 ms.

    You must implement the functionality of the timer, which shows the remaining time in the window.

    You must implement the pawn's movement across the board. The board is an array of buttons (JButton[]).

    Loss Condition: If the time runs out without the pawn being caught, a "Game Over" message must be displayed.

    Win Condition: If the user successfully clicks on the cell containing the pawn, a congratulatory message must be displayed.

    (Initial code for the visual interface, events, and utility methods is provided.)

    (Video reference available in resources/doc)
