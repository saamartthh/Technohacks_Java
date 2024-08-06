import java.util.Scanner;

public class QuizGame {
    
    // Questions, options, and answers arrays
    private static String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the largest ocean on Earth?",
        "What is the boiling point of water?"
    };

    private static String[][] options = {
        {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
        {"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"},
        {"1. William Shakespeare", "2. Charles Dickens", "3. Mark Twain", "4. Jane Austen"},
        {"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"},
        {"1. 90°C", "2. 100°C", "3. 110°C", "4. 120°C"}
    };

    private static int[] answers = {3, 2, 1, 4, 2}; // Correct answers

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Please enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == answers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + answers[i] + ".\n");
            }
        }

        System.out.println("You scored " + score + " out of " + questions.length + ".");
        scanner.close();
    }
}
