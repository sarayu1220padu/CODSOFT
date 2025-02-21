import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = r.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;

            System.out.println("I've picked a number between 1 and 100. You have " + maxAttempts + " tries.");

            while (attempts < maxAttempts) {
                System.out.print("Your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You ran out of tries. The number was " + secretNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (Yes/No): ");
            String playChoice = sc.next();
            playAgain = playChoice.equals("Yes");
        }
        System.out.println("Thanks for playing! Your final score is: " + score);
        sc.close();
    }
}
