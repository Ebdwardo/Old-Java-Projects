// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: this program prints a row or pyramid per user request using a separate class


import javax.swing.*;
import java.util.Scanner;

public class Lab7
{
    public static void main(String[] args)
    {
        // Declare variables if needed
        // -->
        final String ROWS = "*";
        String userName;

        // Declare a Scanner object
        // -->
        Scanner input = new Scanner(System.in);

        // Get the name from the user and store it in a variable
        // -->
        System.out.println("Name of the builder: ");
        userName = input.nextLine();

        // Create a brand-new builder with a given name using our Builder class
        // and the name of the user. The syntax is pretty similar to the way
        // you use Scanner
        // -->
        Builder builder1 = new Builder(userName);

        // Print the name of the builder by its method.
        System.out.print("\nThe name of builder is: ");
        // -->
        System.out.println(builder1.getName());

        // ======================= Use makeRow =======================

        // Ask for integer n from user by Scanner
        System.out.println("\nEnter a positive integer:");
        // -->
         int userInt = input.nextInt();

        // Using your builder's makeRow method print the pattern
        // -->
        System.out.println(builder1.makeRow(userInt, ROWS)+"\n");

        // ======================= Use makePyramid =======================

        // Ask for odd integer t from user by Scanner
        System.out.println(
            "Enter a positive odd integer, " +
            "representing number of stars in the base of a pyramid:");
        int pyramidBase = input.nextInt();

        // Using the Builder method makePyramid and integer t,
        // print pyramid with "*" as a string
        // -->
        builder1.makePyramid(pyramidBase, ROWS);


    }
}