//         Name: Eduardo Teodosio Campuzano
//  Description: This class reads integers from a keyboard and prints out
//               the minimum integer, count of odd integers, largest even integer, and sum of positive integers.

import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        // Declare variables
        int even = 0;
        int min = 0;
        int odd = 0;
        int sumPositive = 0;

        // Create a scanner object
        Scanner scan = new Scanner(System.in);

        // Create a while loop to run until 0 is entered at which point it will end
        while (true) {
            int userInput = scan.nextInt();

            // See if the user entered an even number and if it is grater than the previous
            if (userInput % 2 == 0 && userInput > even) {
                even = userInput;
            }

            // Find the min by comparing it to 0 since 0 is included
            if (userInput <= min) {
                min = userInput;
            }

            // Check to see if the value is positive then add
            if (userInput > 0) {
                sumPositive += userInput;
            }

            // Check to see if it is odd and add one to the odd counter
            if (userInput % 2 != 0) {
                odd++;
            }

            // When the user enters zero it will display the results and end the program
            if (userInput == 0) {
                System.out.println("The minimum integer is " + min);
                System.out.println("The count of odd integers in the sequence is " + odd);
                System.out.println("The largest even integer in the sequence is " + even);
                System.out.println("The sum of positive integers is " + sumPositive);
                break;
            }
        }
    }
}


