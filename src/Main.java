import java.util.Scanner;
import java.util.Random;

public class Main {
    static void main(String[] args) {

// Create Scanner for user input and Random Number Generator
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create Variables
        int playnum = 1;
        int guesses = 0;
        int count = 0;

        // Create the Random Number
        int number = random.nextInt(0,101);

        // Welcome message and rules
        System.out.println("Welcome to my number guessing game.");
        System.out.println("The rules of this game are: Enter a # and I'll tell you if it it higher or lower.");
        System.out.print("Are you ready to start (y/n): ");
        String confirm = scanner.nextLine();
        System.out.println("Please choose your difficulty: (easy, medium or hard,)");
        String difficulty = scanner.nextLine();
        System.out.println("Your difficulty is " + difficulty);

// User difficulty, Determines the amount of guesses the player has.
                if (difficulty.equals("easy".toLowerCase())) {
                   guesses = 20;
                } else if (difficulty.equals("medium".toLowerCase())) {
                    guesses = 15;
                } else if (difficulty.equals("hard".toLowerCase())) {
                    guesses = 10;
                } else {
                    System.out.println("Invalid difficulty. Try again.");
                }

                // While loop to run the game unless the if statements below are met. (the if statements outside the while loop)
        while (playnum != number) {
            System.out.print("Enter your #: ");
            playnum = scanner.nextInt();

            count++;

            if (playnum > number) {
                System.out.println("The number is less than: " + playnum);
            } else if (playnum < number) {
                System.out.println("The number is greater than: " + playnum);
            } else if (playnum > 100) {
                System.out.println("Please enter a valid number");
            } else if (playnum < 0) {
                System.out.println("Please enter a valid number");
            } else if (playnum == number) {
                System.out.println();
            } else {
                System.out.println("Please enter a valid number");
            }
        }

        // Checks if player runs out of guesses and player guess is NOT equal to the random number.
        if (count >= guesses && playnum != number) {
            System.out.println("Uh oh! You lost.");
            System.out.println("The number was: " + number);
        }

        // Checks if player still has guesses leftover and guesses the correct number.
        if (count < guesses && playnum == number) {
            System.out.println("Congratulations! You win!");
            System.out.println("The number was: " + number);
        }
// Outputs the amount of guesses it takes for user to guess the correct number.
        System.out.println("You took: " + count + " guesses");

        scanner.close();

    }
}