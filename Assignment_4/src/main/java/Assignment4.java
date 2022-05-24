//AUTHOR: Eduardo Teodosio Campuzano
//SPECIFICATION: This program will have the user input an integer and tell them
//whether it is a prime number or not and will give the min, max, sum, count,
//and average of all the numbers they input

import java.util.Scanner;

public class Assignment4 {

    //Here I created a sentinel for me to use to end the do while loop
    public static final int QUIT = -1;

    public static void main(String[] args) {

        // This is where I created the scanner object and initialized all the variables I am going to be using in this code.
        Scanner in = new Scanner(System.in);
        int userInt;
        int sum = 0, max = 0, min = 0;
        int count = 0;
        double average = 0;

        //Here is where the do while loop is. This loop is going to ask the user for number and tell them if its prime and give them other useful info about all the numbers they enter
        do {
            System.out.println("Enter an integer. Enter -1 to quit.");
            userInt = in.nextInt();

            // Once the user has enter an integer this is what will calculate the sum, average, max, min, count and tell if it is prime
            // It will do this as long as the user does not enter the sentinel value
            if (userInt != QUIT) {
                count++;
                sum += userInt;
                average = (double) sum / count;

                boolean primeResult = true;

                for (int i = 2; i < userInt; i++) {
                    if (userInt % i == 0) {
                        primeResult = false;
                        break;
                    }
                }
                if (primeResult) {
                    System.out.println("The number " + userInt + " is prime");
                } else if (!primeResult) {
                    System.out.println("THe number " + userInt + " is not prime");
                }

                if (max == 0) {
                    // first input
                    max = userInt;
                    min = userInt;
                } else {
                    if (userInt >= max) {
                        max = userInt;
                    }
                    if (userInt <= min) {
                        min = userInt;
                    }
                }
            }
        }
        while (userInt != QUIT);

        //once the do while loop has been broken  out of by the user the results of all the numbers they inputted in the loop will be displayed here.
        System.out.println("The maximum number is: " + max);
        System.out.println("The minimum number is: " + min);
        System.out.println("The sum is: " + sum);
        System.out.println("The count of number(s)is: " + count);
        System.out.println("the average is: " + (average));
    }
}
