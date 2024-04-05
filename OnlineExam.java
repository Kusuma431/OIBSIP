import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Examination {
    private List<Question> questions;

    public Examination() {
        questions = new ArrayList<>();
        // Add some sample questions
        questions.add(new Question("What is the capital of France?",
                new String[] { "A. Paris", "B. London", "C. Berlin", "D. Rome" }, 0));
        questions.add(new Question("Who wrote 'To Kill a Mockingbird'?",
                new String[] { "A. Harper Lee", "B. J.K. Rowling", "C. Charles Dickens", "D. Mark Twain" }, 0));
        questions.add(new Question("What is the chemical symbol for gold?",
                new String[] { "A. Au", "B. Ag", "C. Fe", "D. Cu" }, 0));
    }

    public void conductExamination() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Enter your choice (A, B, C, D): ");
            String choice = scanner.nextLine().toUpperCase();
            int selectedOption = choice.charAt(0) - 'A';

            if (selectedOption == question.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
        }

        System.out.println("Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        Examination examination = new Examination();
        examination.conductExamination();
    }
}
