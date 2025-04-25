package ReaneyModule9ProgrammingAssignment;

/**
 *
 *  @author: Christopher Reaney
 *  Assignment: Module 9 Programming Assignment
 *  Date: 04/25/2025
 *  This class is used to call out to the three code examples we were provided 
 *      in order to fulfill the testing requirements of this assignment
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Running the CreateTable class...");
            CreateTable.main(null);

            System.out.println("\nRunning the InsertData class...");
            InsertData.main(null);

            System.out.println("\nRunning the Select5 class...");
            Select5.main(null);

            System.out.println("\nAll operations completed successfully.");
        } catch (Exception e) {
            System.err.println("\nError during execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}