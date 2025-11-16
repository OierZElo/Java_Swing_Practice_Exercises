🏋️ Programming III & Application Programming: Partial Exam (Extraordinary)

Course: 2024/2025 Date: [No Date Provided in Source] Total Score: 4.5 points (Duration: 2.5h)

📜 Instructions

    Before starting the exam, you must follow the steps indicated in the instructions sheet.

    This exam continues with the gym management domain and proposes exercises to recover the following competencies: CE1 (Swing), CE2 (Threads), CE3 (JDBC), and CE4 (Recursion).

    Important: You must complete all competencies that you did not pass in previous exams. If you retake an already passed competency, the highest score obtained across any of the performed exams will be used.

    For each task, the score (out of 4.5 points), the class where the code should be added, and an estimated number of lines are indicated.

    The provided base code is organized into separate packages, one per competency, each containing a main() method for testing.

✅ Exam Tasks

Task 1: Swing [1.5 points]

    Classes: TablaPersonasModelo, TablaPersonas

    Estimate: 50 lines

Objective: Complete the necessary code to visualize person data in the currently blank table, achieving the structure and appearance shown in the reference image.

Steps:

    Complete the partial data model provided in the TablaPersonasModelo class to display the table structure shown in the image.

    Implement a renderer for the table located in TablaPersonas such that, in the 'Abono' (Subscription) column, the subscription types (SIMPLE, DUO, and COMPLETO) appear with text colors of orange, blue, and green, respectively.

    Add 3 buttons (one for each subscription type) to the top of the window. When the user clicks any of them, the corresponding subscription cell in the table must be highlighted with a yellow background.

    (Expected result visible in the video contained in the resources/doc folder.)

Task 2: Threads [1 point]

    Class: MainThreads

    Estimate: 30 lines

Objective: Implement a visual effect where panels in a grid periodically swap colors, controlled by start/stop buttons.

Requirements:

    The window provides a grid of Swing panels.

    When the user clicks "Iniciar" (Start), each panel must periodically exchange its background color between RED and LIGHT_GRAY.

    The visualization must be able to be stopped with the "Parar" (Stop) button and restarted again.

    The period (time between color changes) for each grid panel is set randomly every time the user clicks "Iniciar" and remains fixed until the visualization is stopped.

    You have auxiliary methods periodoAleatorio() and cambiarEstado() available to help implement the required functionality.

    (Expected behavior visible in the video contained in the resources/doc folder.)
