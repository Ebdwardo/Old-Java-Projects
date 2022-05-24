// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This program will take the integers the user types for all three tests and give the average of all three tests

import java.util.Scanner;

// class name should match the file name
public class Lab1 {

    // we must have a main method to run the program
    public static void main(String[] args) {

        // create a Scanner object to get input from the keyboard
        Scanner userTests = new Scanner(System.in);


        // declare variables
        int test1;
        int test2;
        int test3;
        final int NUM_TESTS = 3;


        // Get the Input
        System.out.print("Enter the score on the first test: ");
        test1 = userTests.nextInt();

        System.out.print("Enter the score on the second test: ");
        test2 = userTests.nextInt();

        System.out.print("Enter the score on the third test: ");
        test3 = userTests.nextInt();

        // Calculate the average
        double averageScore = ((test1 + test2 + test3) / (double) NUM_TESTS);


        // Display Results
        System.out.println("Your average score is: " + averageScore);


    }//end main method
}//end Lab1 class
