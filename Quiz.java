import java.util.Scanner;
public class Quiz
 {
    public static void main(String[] args)
     {
         
        String[][] questions = {
            {"What does 'HTML' stand for?", "A. HyperText Machine Language", "B. Hyperlink and Text Management Language", "C. HyperText Markup Language", "D. High-Level Machine Language", "C"},
            {"Which planet is known as the Red Planet?", "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn", "B"},
            {"What is 2 + 2?", "A. 3", "B. 4", "C. 5", "D. 6", "B"},
            {"Which programming language is known for its object-oriented nature?", "A. C", "B. Java", "C. Python", "D. Assembly", "B"},
            {"What is the largest mammal?", "A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Shark", "B"}
        };
        int score = 0; 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Welcome to the  Quiz!");
        System.out.println("Answer the following questions:\n");

        for (int i = 0; i < questions.length; i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);  
            for (int j = 1; j <= 4; j++) 
            {
                System.out.println(questions[i][j]);  
            }
            System.out.println("Your answer (A/B/C/D): ");
            String userAnswer = sc.next().toUpperCase();  
            if (userAnswer.equals(questions[i][5])) 
            {
                System.out.println("Correct!\n");
                score++; 
            } else 
            {
                System.out.println("Incorrect! The correct answer is " + questions[i][5] + ".\n");
            }
        }

        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("Thank you for playing!");

        sc.close();  
    }
}
