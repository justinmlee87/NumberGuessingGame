
//importing the random and scanner features for the program.
import java.util.Random;
import java.util.Scanner;

//interface to specify behavior of the NumberGuessingGame by providing an abstract type.
interface NumberGuessingGame {

    void playGame();
}

// Class to utilize implements to call on and implement the interface
// Sets the maximum number of attempts to 10
class SimpleNumberGuessingGame implements NumberGuessingGame {

    // Sets maximum number of attempts
    private final int maxAttempts = 10;

    @Override

    public void playGame() {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        // Generates a random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;

        // Displays welcome Message to the user.
        System.out.println("Welcome to the Number Guessing Game!");

        // Prompts user to try to guess the number that has been randomly selected.
        System.out.println("I have selected a number between 1 and 100. Try to guess it.");

        // defaults number of guess attempts to 0 to begin.
        int attempts = 0;

        // loop to prompt user to guess
        while (attempts < maxAttempts) {

            // beginning of the loop, prompting user to guess.
            System.out.print("Enter your guess: ");

            int userGuess = scanner.nextInt();

            attempts++;

            // Check if the guess is correct.

            // If the guess is correct, it displays a congratulatory message to the user.
            // If the guess is too low, a too low message is displayed prompting the user to
            // try again.
            // If the guess is too high, a too high message is displayed prompting the user
            // to try again.
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
        // Output if the maximum number of guess attempts has been reached.
        if (attempts == maxAttempts) {
            System.out.println(
                    "Sorry, you've reached the maximum number of attempts. The correct number was: " + secretNumber);
        }

        // closes the scanner
        scanner.close();
    }
}

// Class to call the game as based on the file
public class game {
    public static void main(String[] args) {
        NumberGuessingGame game = new SimpleNumberGuessingGame();
        game.playGame();
    }
}