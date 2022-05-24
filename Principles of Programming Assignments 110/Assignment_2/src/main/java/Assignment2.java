// AUTHOR: EDUARDO TEODOSIO CAMPUZANO
// SPECIFICATION: This program will read the user input for 2 players and make sure they enter valid responses for the game rock paper scissors.
// It will then declare a winner based off of who chose what.

import java.util.Scanner;

public class Assignment2 {
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// The code I have written will ask the 2 players to choose rock paper or scissors. If it sees that one of the players has entered something other than that it will display Wrong Choice. If they both
// choose something allowed it will then chose a winner based off the rules of rock paper scissors using the regular and nested if, else if and else statements I have added.
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        // I created a scanner object for the user to be able to type their inputs and to make use of the API I have imported
        Scanner in  = new Scanner(System.in);

        // Using these lines of code I am simultaneously asking the players to choose their throw and am having my code store their response
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String player1Choice = in.nextLine();

        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String player2Choice = in.nextLine();

        // These lines of code are taking the response from each player gathered above and converting the strings into lowercase letters so it wont matter what combination of letters they respond with
        // I will then takes these variables and compare them to the choices rock, paper and scissors. Since the choices are all lowercase now I dont need to account for different variations in answers.
        player1Choice = player1Choice.toLowerCase();
        player2Choice = player2Choice.toLowerCase();

        // This beginning if statement will check if the players have entered valid responses, if not they will be prompted with "Wrong Choice!"
        if ((player1Choice.equals("rock")||player1Choice.equals("paper")||player1Choice.equals("scissors")) && (player2Choice.equals("rock")||player2Choice.equals("paper")||player2Choice.equals("scissors"))) {

            // This nested if statement will run once both players have entered a valid choice, once that has occurred it will check if the first player has entered "rock", if no it will move on
            if (player1Choice.equals("rock")){

                // If player one did choose rock it will compare it to all three of player 2's possible choices contained below
                // If player 2 chose rock it will output "It is a tie"
                if (player2Choice.equals("rock")){
                    System.out.println("It is a tie.");
                }

                // If player 2 chose paper it will output "Player 2 wins."
                else if (player2Choice.equals("paper")){
                    System.out.println("Player 2 wins.");
                }

                // If player 3 chose scissors it will output "Player 1 wins."
                else if (player2Choice.equals("scissors")){
                    System.out.println("Player 1 wins.");
                }
            }

            // This set of if and else if statements will run if player one chose "paper"
            if (player1Choice.equals("paper")){

                // If player 2 also chose paper it will display "It is a tie."
                if (player2Choice.equals("paper")){
                    System.out.println("it is a tie.");
                }

                // If player 2 chose scissors it will display"Player 2 wins."
                else if (player2Choice.equals("scissors")){
                    System.out.println("Player 2 wins.");
                }

                // If player 2 chose rock it will display "Player one wins."
                else if (player2Choice.equals("rock")){
                    System.out.println("Player 1 wins.");
                }
            }

            // This set of if and else if statements will run if player one has chosen "scissors"
            if (player1Choice.equals("scissors")){

                // If player 2 has also chosen scissors it will display "It is a tie."
                if (player2Choice.equals("scissors")){
                    System.out.println("It is a tie.");
                }

                // If player 2 has chosen rock it will display "Player 2 wins."
                else if (player2Choice.equals("rock")){
                    System.out.println("Player 2 wins.");
                }

                // If player 2 has chosen paper it will display "Player one wins."
                else if (player2Choice.equals("paper")){
                    System.out.println("Player 1 wins.");
                }
            }
        }

        // This is what will be outputted if a player types something that is not rock, paper or scissors.
        else {
            System.out.println("Wrong Choice!");
        }
    }
}
