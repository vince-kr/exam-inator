package system.exam;

public class MultipleChoice extends Exam implements Scorable {
    private int correctAnswers;
    private int noQuestions;

    public MultipleChoice(
            int examId,
            String subject,
            int duration,
            int correctAnswers,
            int noQuestions
    ) throws ExamException {
        super(examId, subject, duration);
        if (correctAnswers < 0) {
            throw new ExamException("Correct answers cannot be negative!");
        }
        if (noQuestions < 10 || noQuestions > 50) {
            throw new ExamException("Number of questions must be between 10 and 50!");
        }
        this.correctAnswers = correctAnswers;
        this.noQuestions = noQuestions;
    }

    String displayExamDetails() {
        return "Hello, world!";
    }

    @Override
    public int calculateScore() {
        double scorePercent = (double) correctAnswers / noQuestions * 100;
        return (int) Math.round(scorePercent);
    }
}
