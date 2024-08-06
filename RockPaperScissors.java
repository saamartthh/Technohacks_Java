import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] choices = {"rock", "paper", "scissors"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter your move (rock, paper, scissors). To exit the game, type \"exit\":");
            String userMove = scanner.nextLine().toLowerCase();

            if (userMove.equals("exit")) {
                playAgain = false;
                break;
            }


            if (!isValidMove(userMove)) {
                System.out.println("Invalid move! Please enter rock, paper, or scissors.");
                continue;
            }

            String computerMove = getComputerMove();
            System.out.println("Computer move: " + computerMove);

            String result = determineWinner(userMove, computerMove);
            System.out.println(result);
        }

        scanner.close();
    }

    private static boolean isValidMove(String move) {
        for (String choice : choices) {
            if (choice.equals(move)) {
                return true;
            }
        }
        return false;
    }

    private static String getComputerMove() {
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private static String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "It's a tie!";
        }

        switch (userMove) {
            case "rock":
                return (computerMove.equals("scissors")) ? "You win!" : "You lose!";
            case "paper":
                return (computerMove.equals("rock")) ? "You win!" : "You lose!";
            case "scissors":
                return (computerMove.equals("paper")) ? "You win!" : "You lose!";
            default:
                return "Unexpected error.";
        }
    }
}
