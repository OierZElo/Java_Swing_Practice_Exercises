🏋️ Programming III & Application Programming: Partial Exam

Course: 2024/2025 Date: November 15, 2024 Total Score: 10 points (Duration: 2.5h)

📜 Instructions

    Before starting the exam, you must follow the steps indicated in the instructions sheet.

    The exam is related to a gym's activities. We'll create two designs for the weekly schedule (Tasks 1, 2, and 3) and a game inspired by a Slot Machine (Task 4).

    The application domain consists of 2 classes (Actividad and Sesión) and 2 enumerations (TipoActividad and DiaSemana).

    The base code is organized into 3 packages, each containing a main() class for execution: MainLayout (Task 1), MainJTable (Tasks 2 and 3), and SlotMachineGame (Task 4).

    Visual references (images and a video) are available in the resources/doc folder.

✅ Exam Tasks

Task 1: Layout [2 points]

    Class: HorarioGimnasioLayout

    Estimate: 70 lines

Objective: Design a view of the gym's weekly activity schedule that exactly replicates the design shown in the reference image.

Requirements:

    Process the list of activities (List<Actividad>) created in the MainLayout class.

    You CANNOT use any JTable component.

    You can only use basic components and the following layouts: FlowLayout, BorderLayout, and GridLayout.

    Note that each instance of the TipoActividad enumeration has a Color attribute.

Task 2: JTable Handling and Rendering

General Objective: Create a new design for the weekly schedule based on a JTable component, achieving the exact appearance shown in the reference image.

Task 2.1: Data Model [1.5 points]

    Class: HorarioGimnasioModel

    Estimate: 60 lines

Objective: Create a custom data model (HorarioGimnasioModel) to initialize the activity table using the list of activities (List<Actividad>) created in MainJTable.

Requirements:

    The class constructor must receive a list of activities (List<Actividad>) as a parameter.

    No cell in the table should be editable.

    You must carefully determine the return value of the getValueAt() method for each value the model provides to the JTable.

    The new model must be used in the HorarioGimnasioJTable class to initialize the tablaActividades table.

Task 2.2: Design and Rendering [1.5 points]

    Class: HorarioGimnasioJTable

    Estimate: 60 lines

Objective: Achieve the final design of the activities table.

Requirements:

    Prevent the table columns from being rearranged.

    The texts for hours and days must use Arial 18-point, bold typography.

    The table must not have any grid lines.

    Images representing each activity type are located in the resources/images/ folder.

    The activity name must be shown when the user positions the mouse over a cell containing activity information (Tooltip).

    Remember that each TipoActividad has a Color attribute.

Task 3: Keyboard Event [1 point]

    Class: HorarioGimnasioJTable

    Estimate: 25 lines

Objective: Enable application shutdown, as the window currently cannot be closed using the title bar's 'X'.

Requirements:

    Implement the necessary functionality to capture the keystroke combination CTRL + E.

    Upon capture, show a confirmation dialog box using JOptionPane (as shown in the reference image).

    If the user clicks "Yes", the application closes; otherwise, nothing happens.

Task 4: Threads [4 points]

    Class: SlotMachineGame

    Estimate: 30 lines

Objective: Implement a Slot Machine game where the prize is a monthly gym subscription.

Concurrency and Logic Requirements:

    Provide dynamism to 3 JLabels that display images of the gym's activity types in a continuous, random sequence.

    Design a series of threads to change the image of each JLabel randomly every 100 milliseconds. The sequence must be continuous and completely independent for each JLabel.

    The sequence starts when the "Iniciar" (Start) button is pressed and stops completely when the "Parar" (Stop) button is pressed.

    Once stopped, check if the 3 images are identical to award the prize.

    The sequence can be restarted until the prize is won. After winning, a message must be displayed indicating that the user cannot continue playing.

    (Video reference of the required behavior is in resources/doc)
