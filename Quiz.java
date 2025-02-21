import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    List<Question> questions;
    int Score = 0;
    int currentQuestion = 0;
    List<String> userAnswers = new ArrayList<>();
    Scanner sc = new Scanner(System.in); 

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public void start() {
        while (currentQuestion < questions.size()) {
            Question question = questions.get(currentQuestion);
            displayQuestion(question);

            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    handleAnswer("No answer", question);
                    currentQuestion++;
                    if (currentQuestion < questions.size()) {
                        start();
                    } else {
                        display();
                    }
                    t.cancel(); // Cancel timer after timeout
                }
            }, 10000);

            System.out.print("Enter your answer (1-4): ");
            if (sc.hasNextInt()) {
                int userAnswer = sc.nextInt();
                t.cancel(); // Cancel timer if answer is provided
                if (userAnswer >= 1 && userAnswer <= 4) {
                    handleAnswer(userAnswer - 1 == question.correctAnswer ? "Correct" : "Incorrect", question);
                } else {
                    System.out.println("Invalid input! Please enter a number between 1 and 4.");
                    handleAnswer("No answer", question);
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                sc.next(); //   invalid input
                handleAnswer("No answer", question);
            }
            currentQuestion++;
            if (currentQuestion == questions.size()) display();
        }
        sc.close();  
    }

    private void handleAnswer(String answer, Question question) {
        userAnswers.add(answer);
        if (answer.equals("Correct")) Score++;
    }

    private void displayQuestion(Question question) {
        System.out.println("\nQuestion " + (currentQuestion + 1) + ": " + question.questionText);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println((i + 1) + ". " + question.options[i]);
        }
    }

    private void display() {
        System.out.println("\n**Quiz Completed ***\n");
        System.out.println("Your final score: " + Score + "/" + questions.size());

        System.out.println("\n--- Correct Answers ---\n");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            System.out.println("Correct Answer: " + question.options[question.correctAnswer]);
            System.out.println("Your Response: " + userAnswers.get(i));
            System.out.println();
        }
        System.exit(0);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> ques = new ArrayList<>();

        System.out.println("Welcome to Quiz Application");
        System.out.println();
        ques.add(new Question("Which OOP concept is achieved by method overloading and overriding?", new String[]{"Encapsulation", "Polymorphism", "Abstraction", "Inheritance"}, 1));
        ques.add(new Question("What is the superclass of all classes in Java?", new String[]{"Object", "Main", "Super", "Parent"}, 0));
        ques.add(new Question("Which keyword is used to handle exceptions in Java?", new String[]{"try", "catch", "throw", "All of the above"}, 3));
        ques.add(new Question("Which package is automatically imported into every Java program?", new String[]{"java.util", "java.lang", "java.io", "java.math"}, 1));
        
        Quiz q = new Quiz(ques);
        q.start();
    }
}
