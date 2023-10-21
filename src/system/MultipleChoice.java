package system;

public class MultipleChoice extends exam implements Scorable {
    private int correctAnswers;
    private int noQuestions;

    String displayExamDetails() {
        return "Hello, world!";
    }

    @Override
    public int calculateScore() {
        double scorePercent = (double) correctAnswers / noQuestions * 100;
        return (int) Math.round(scorePercent);
    }
}
