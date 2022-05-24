// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This program takes the Homework, Midterm and Final user input and calculates the grade based on the formula
// it does this through if else statements by checking that the user input is in the range and running according to the while loop

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // This scanner is prepared for you to get inputs
        Scanner scanner = new Scanner(System.in);

        // Declare three variables for HW, midterm, and final exam grades
        double userHw = 0, userMid = 0, userFinal = 0;

        // Declare a loop control variable i
        int i = 0;

        while (i < 3) {
            // Design if-else control flow:

            // if i is 0, asks for the homework grade
            // if i is 1, asks for the midterm exam grade
            // if i is 2, asks for the final exam grade

            // You have to let the user re-try if any of the inputs is invalid.
            // - homework grade is in [0, 100]
            // - midterm grade is in [0, 100]
            // - final exam grade is in [0, 200]

            // The first if-else statement is attached for your reference. You have to
            // finish the last two statements by yourself

            if (i == 0) {
                // Ask the user for homework grade
                System.out.print("Enter your HOMEWORK grade: ");

                // Do input validation
                userHw = scanner.nextDouble();

                if (userHw<0 || userHw > 100) {
                    // Show the error message
                    System.out.println("[ERR] Invalid input. A homework grade should be between [1,100]");

                } else {

                    // Update the loop variable
                    i++;
                }
            }

            // The other two if-else statements go here

            if (i == 1) {

                System.out.print("Enter your MIDTERM grade: ");
                userMid = scanner.nextDouble();

                if (userMid > 100 || userMid <0) {

                    System.out.println("[ERR] Invalid input. A midterm grade should be between [1,100]");
                } else {

                    i++;
                }
            }
            if (i == 2) {

                System.out.print("Enter your FINAL EXAM grade: ");
                userFinal = scanner.nextDouble();

                if (userFinal > 200 || userFinal <0 ) {

                    System.out.println("[ERR] Invalid input. A finaL grade should be between [1,200]");
                }
                else{

                    i++;
                }
            }
        }

        // Calculate the weighted total by the formula showed in the PDF

        double weighted_total = ((userFinal/200)*50)+(userMid*.25)+(userHw*.25);

        // Show the weighted total and tell the user s/he passed or not

        System.out.println("[INFO] Student's Weighted Total is " + weighted_total);
        if (weighted_total>= 50) {
            // Print "the student PASSED the class."
            System.out.println("[INFO] the student PASSED the class");

        } else {
            // Print "the student FAILED the class."
            System.out.println("[INFO] the student FAILED the class");

        }

        scanner.close();

    }  // End of main
}  // End of class
