package examinator.exam;

import java.util.StringTokenizer;

public class Essay extends Exam implements Scorable {
    String essayAnswer;
    int wordCount;
    int grammar;
    int content;
    int wordLimit;

    public Essay(
            int examId,
            String subject,
            int duration,
            String essayAnswer,
            int grammar,
            int content,
            int wordLimit) throws ExamException {
        super(examId, subject, duration);
        this.wordCount = new StringTokenizer(essayAnswer).countTokens();
        if (wordCount < 0) {
            throw new ExamException("Word count must be greater than zero!");
        }
        this.essayAnswer = essayAnswer;
        this.grammar = grammar;
        this.content = content;
        this.wordLimit = wordLimit;
        if (wordLimit < 500 || wordLimit > 10000) {
            throw new ExamException("Word limit must be between 500 and 10,000!");
        }
    }

    @Override
    public String getType() {
        return "Essay";
    }

    private int gradeEssay() {
        // Grammar weight 30%, content weight 70%
        double essayScore = grammar * 0.3 + content * 0.7;
        essayScore *= wordCountPenalty();
        return (int) Math.round(essayScore);
    }

    private double wordCountPenalty() {
        double penalty = 1;

        // Bounds 10% above and below the word limit
        double wordLimitUpper = wordLimit * 1.1;
        double wordLimitLower = wordLimit * 0.9;

        // Penalise too few words by 20% and too many words by 5%
        if (wordCount < wordLimitLower) {
            penalty = 0.8;
        } else if (wordCount > wordLimitUpper) {
            penalty = 0.95;
        }

        return penalty;
    }

    public String displayExamDetails() {
        return String.format("ESSAY DETAILS\n\tSubject:\t %s\n\tDuration:\t %d\n\t", this.subject, this.duration);
    }

    @Override
    public int calculateScore() {
        return gradeEssay();
    }
}
