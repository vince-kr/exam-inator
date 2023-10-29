package examinator.exam;

public class MultipleChoice extends Exam implements Scorable {
    private final int correctAnswers;
    private final int noQuestions;

    public MultipleChoice(
            int examId,
            String subject,
            int duration,
            int correctAnswers,
            int noQuestions
    ) throws ExamException {
        super(examId, subject, duration);
        if (correctAnswers < 0) {
            throw new ExamException("Number of correct answers cannot be negative!");
        }
        if (noQuestions < 10 || noQuestions > 50) {
            throw new ExamException("Number of questions must be between 10 and 50!");
        }
        this.correctAnswers = correctAnswers;
        this.noQuestions = noQuestions;
    }

    public String displayExamDetails() {
        return String.format("MULTIPLE CHOICE DETAILS\n\tSubject:\t %s \n\tDuration:\t %d", this.subject, this.duration);
    }

    @Override
    public int calculateScore() {
        double scorePercent = (double) correctAnswers / noQuestions * 100;
        return (int) Math.round(scorePercent);
    }
}
