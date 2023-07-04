import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int minRange = 1; // Minimum range for the generated number
        int maxRange = 100; // Maximum range for the generated number
        int maxAttempts = 5; // Maximum number of attempts allowed

        int score = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                attempts++;
                totalAttempts++;

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low!");
                } else {
                    System.out.println("Your guess is too high!");
                }
            }

            if (guessedCorrectly) {
                score++;
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
            } else {
                System.out.println("Oops! You did not guess the number. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.nextLine();

            if (!playAgainChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            System.out.println();
        }

        System.out.println("Game Over!");
        System.out.println("Total score: " + score);
        System.out.println("Total attempts: " + totalAttempts);

        scanner.close();
    }
}
