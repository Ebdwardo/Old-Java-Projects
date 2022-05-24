// AUTHOR: EDUARDO TEODOSIO CAMPUZANO
// SPECIFICATION: This program will ask the user for 2 strings one after the other.
// then prompt the user with a menu asking them to type the letter of the choice they want
// the user will be able to request choices until they choose to quit the program.

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        // We start our code by creating a scanner object fort user input
        Scanner userInput = new Scanner(System.in);

        //Here we are asking the user to enter 2 strings one after the other
        System.out.println("Please enter a string.");
        String string1 = userInput.nextLine();
        System.out.println("Please enter another string.");
        String string2 = userInput.nextLine();

        // Here I am initializing a variable that will later store the users menu choice
        String userOption = null;

        //Here I am creating the menu the user will see and have to choose an option from
        System.out.println("\nCommand Options ");
        System.out.println("-----------------------");
        System.out.println("a: check if the length of the two strings are the same.");
        System.out.println("b: checks if the two strings are the same or different.");
        System.out.println("c: checks which string is lexically larger, or if they are the same.");
        System.out.println("d: prints out the first character (index 0) of each string.");
        System.out.println("e: prints out a new string consisting of the first string concatenated (appended) with the second string.");
        System.out.println("f: prints out the two strings in uppercase letters.");
        System.out.println("q: quit the program.");

        //This is where I start my do while loop which will keep asking the user to choose options till they quit
        do {
            //The do loop will start by asking and storing the letter of the users choice
            // while also making the letter of what they choose capital so it works with capital and lowercase letters
            System.out.println();
            System.out.println("Please enter an option or type");
            userOption = userInput.nextLine();
            userOption = userOption.toLowerCase();

            //Our switch statement will run through the possible menu choices and output the appropriate result
            switch (userOption) {
                //If they choose "a" the program will check the lengths of the strings and see if they are they same or not and tell the user
                case "a":
                    if (string1.length() == string2.length()) {
                        System.out.println("The lengths are the same.");
                    } else {
                        System.out.println("the lengths are not the same.");
                    }
                    break;
                //If they choose "b" the program will check to see if the strings are identical and tell the user if they are or are not
                case "b":
                    if (string1.equals(string2)) {
                        System.out.println("The two strings are the same.");
                    } else {
                        System.out.println("The two strings are different.");
                    }
                    break;
                //If they choose "c" the program will tell the user which string is lexically larger than the other
                case "c":
                    if (string1.compareTo(string2) == 0) {
                        System.out.println("The strings are lexically the same.");
                    } else if (string1.compareTo(string2) > 0) {
                        System.out.println("The first string is lexically larger than the second string.");
                    } else if (string1.compareTo(string2) < 0) {
                        System.out.println("The second string is lexically larger than the first string.");
                    }
                    break;
                //If they choose "d" the program will tell the user the first letter of each string
                case "d":
                    System.out.println();
                    System.out.println("The first character of the first string is: " + string1.charAt(0));
                    System.out.println("The first character of the second string is: " + string2.charAt(0));
                    break;
                //If they choose "e" The program will output the concatenation of the 2 strings in one line
                case "e":
                    System.out.println("The concatenation of the two strings is " + "\"" + string1 + string2 + "\"");
                    break;
                //If they choose "f" the program will output each string in capital letters on new lines
                case "f":
                    System.out.println();
                    System.out.println("The first string using capital letters is: " + string1.toUpperCase());
                    System.out.println("The second string using uppercase letters is: " + string2.toUpperCase());
                    break;
                //If they choose "q" then the loop will end and the program will stop running while first telling the user to press any key
                case "q":
                    System.out.println("Press any key to continue...");
                    break;
                default:
                    System.out.println("[ERR] enter a valid option");
                    break;
            }
        }
        //This is the while part of the do while loop and the condition I have inside will make it so when the user types "q"
        //the condition is false so the do while loop ends, but keeps running if the choice is anything but "q"
        while (!userOption.equals("q"));
    }
}
