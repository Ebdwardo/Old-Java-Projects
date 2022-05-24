// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This lab collect the user input containing a name, it then converts that name into uppercase and outputs that name. It also outputs the length of the name. It then shows the difference between comparing string using == and equals by using an if statement

import java.util.Scanner;

// class name should match the file name
public class Lab2 {
    // we must have a main method to run the program
    public static void main(String[] args) {

        // declare variables of different types:
        String firstName = "";
        String lastName = "";
        String fullName = "";
        int nameLength = 0;
        Scanner scan = new Scanner(System.in);

        // Use Scanner to ask the user for first name
        System.out.print("Please enter first name: " );
        firstName = scan.nextLine();
        // Use Scanner to ask the user for last name
        System.out.print("Please enter last name: ");
        lastName = scan.nextLine();

        // Add firstName to lastName variables using "+" sign, don't forget the space.
        // store the result in the fullName variable
        fullName = firstName + " " + lastName;

        // Convert fullName variable to upper case
        fullName = fullName.toUpperCase();

        // Find the length of fullName and store it
        // in nameLength variable.
        nameLength = fullName.length();

        // Print fullName, it should be in upper case
        System.out.println("Full name (in capitals); " + fullName);

        // Print nameLength, this should be number of characters
        // in "fullName" variable, including space
        System.out.println("Length of full name: " +nameLength);


        // Define two String variables, title1 and title2 using
        // String constructor to initialize them
        String title1 = new String("cse110");
        String title2 = "cse110";

        // Compare the two strings and print which one of the two ways works
        // follow code below:
        if ( title1 == title2 ) {
            // Print "String comparison using == sign works"
            System.out.println("String comparison using \"==\" works");
        } else {
            // Print "String comparison using == sign does NOT work"
            System.out.println("String comparison using \"==\" does NOT work");
        }
        if ( title1.equals(title2) ) {
            // print "String comparison using equals method works"
            System.out.println("String comparison using \"equals\" method works");
        } else {
            // print "String comparison using equals method does NOT work"
            System.out.println("String method using equals method does NOT work");
        }

    } //end main method
} //end Lab2 class
