//Name: Eduardo Teodosio Campuzano
//Description: This code incorporates user input, using the correct double variables and mathematical logistics to
// correctly output the conversion of the input by the user into yards, feet, inches and centimeters
//Date: 9/10/19

import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment1 {
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    // Reads the distance of a throw in meters and performs a conversion into yards, feet, inches, and centimeters
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        // We are creating a scanner object, so we can collect the user input
        Scanner userInput = new Scanner(System.in);

        // Here we are initialing our constants as double values for us to use later so there are no magic numbers in our code
        final double METER_TO_YARDS = 1.093; //yards
        final double YARDS_TO_FEET = 3.0; //feet
        final double METER_CENTIMETER = 100.0; // centimeter
        final double FEET_TO_INCHES = 12.0; //inches

        // With this code we are creating the header and title for the output and are getting the competitor's name from user input
        System.out.print("Enter the competitor's name: ");
        String firstComp = userInput.nextLine();
        System.out.println();
        System.out.println("\t\t\t\t Javelin Throws");

        // These lines code will simply output asking the user to type the distance for 3 throws and store them as double values 3 times
        System.out.println("\t\tEnter the distance, in meters, for " + firstComp);
        System.out.println();
        System.out.print("Please enter the distance for throw 1: ");
        double throw1 = userInput.nextDouble();
        System.out.print("Please enter the distance for throw 2: ");
        double throw2 = userInput.nextDouble();
        System.out.print("Please enter the distance for throw 3: ");
        double throw3 = userInput.nextDouble();
        System.out.println();

        //These lines of code take the double values the user has inputted and performs the conversion into yards, feet, inches and centimeters
        // and store them as another double values
        double yards1 = throw1 * METER_TO_YARDS;
        double yards2 = throw2 * METER_TO_YARDS;
        double yards3 = throw3 * METER_TO_YARDS;
        double feet1 = yards1 * YARDS_TO_FEET;
        double feet2 = yards2 * YARDS_TO_FEET;
        double feet3 = yards3 * YARDS_TO_FEET;
        double inches1 = feet1 * FEET_TO_INCHES;
        double inches2 = feet2 * FEET_TO_INCHES;
        double inches3 = feet3 * FEET_TO_INCHES;
        double centi1 = throw1 * METER_CENTIMETER;
        double centi2 = throw2 * METER_CENTIMETER;
        double centi3 = throw3 * METER_CENTIMETER;

        // We are using the Decimal Format class in the next lines of code when we need to format our output to specifically 2 decimal places,
        // so we create the variable "round" of Decimal Format class to do just that
        DecimalFormat round = new DecimalFormat("####.00");

        // We are creating a table using 4 lines of text being outputted on lines. The first line will contain the name of the type
        // of variable that will be held in each column.
        // The rest of the lines will use the double values of each type we converted and our Decimal Format class to make sure that
        // the values outputted are properly rounded
        System.out.println("Yards\t\tFeet\t\tInches\t\tCm");
        System.out.println(round.format(yards1) + "\t\t" + round.format(feet1) + "\t\t" + round.format(inches1) + "\t\t" + round.format(centi1));
        System.out.println(round.format(yards2) + "\t\t" + round.format(feet2) + "\t\t" + round.format(inches2) + "\t\t" + round.format(centi2));
        System.out.println(round.format(yards3) + "\t\t" + round.format(feet3) + "\t\t" + round.format(inches3) + "\t\t" + round.format(centi3));

    }
}
