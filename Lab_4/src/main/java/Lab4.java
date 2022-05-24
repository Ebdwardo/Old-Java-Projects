// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This code will ask for the user to choose an option from the menu and then once they have made their choice
// it will execute the action described using a switch statement. It will repeat until the user chooses to quit.


import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        // Declare some variables you need
        Scanner in = new Scanner(System.in);
        int userChoice = 0;
        int numberInput = 0;
        int i= 0;
        int numberSum = 0;
        int numberFactorial = 1;
        int leftMostDigit = 0;

        do {
            // Display the menu
            displayMenu();
            
            // Ask the user for one option
            System.out.println("Please choose and option form the following menu:");
            userChoice = in.nextInt();

            switch (userChoice) {
                // Define four cases for different options. Don't forget "break".
                case 1:
                    System.out.println("Enter a number: ");
                    numberInput = in.nextInt();
                    for (i=0; i<=numberInput; i++){
                        numberSum = numberSum + i;
                    }
                    System.out.println("The sum is : " + numberSum);
                    System.out.println();
                    numberSum = 0;
                    break;
                case 2:
                    System.out.println("Enter a number: ");
                    numberInput = in.nextInt();
                    for (i=1; i<= numberInput; i++){
                        numberFactorial = numberFactorial*i;
                    }
                    System.out.println("The factorial of " + numberInput + " is " + numberFactorial);
                    System.out.println();
                    numberFactorial = 1;
                    break;
                case 3:
                    System.out.println("Enter a number: ");
                    numberInput = in.nextInt();
                    leftMostDigit = numberInput;
                    while(leftMostDigit>=10){
                        leftMostDigit = leftMostDigit/10;
                    }
                    System.out.println("The leftmost digit is " + leftMostDigit);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Bye");
                    return;
            }
        } while (userChoice<5);
    }

    /*
     Print the menu
    */
    private static void displayMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1) Calculate the sum of integers from 1 to m");
        System.out.println("2) Calculate the factorial of a given number");
        System.out.println("3) Display the leftmost digit of a given number");
        System.out.println("4) Quit");
    }
}