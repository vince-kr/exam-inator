package system;

import java.util.StringTokenizer;

public class Essay extends exam implements Scorable {
    String essayAnswer;
    int grammar;
    int content;
    int wordLimit;

    public Essay(String subject, int duration, String essayAnswer, int grammar, int content, int wordLimit) {
        this.subject = subject;
        this.duration = duration;
        this.essayAnswer = essayAnswer;
        this.grammar = grammar;
        this.content = content;
        this.wordLimit = wordLimit;
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
        int wordCount = new StringTokenizer(essayAnswer).countTokens();

        // Penalise too few words by 20% and too many words by 5%
        if (wordCount < wordLimitLower) {
            penalty = 0.8;
        } else if (wordCount > wordLimitUpper) {
            penalty = 0.95;
        }

        return penalty;
    }

    public String displayExamDetails() {
        return String.format("EXAM DETAILS\n\tSubject:\t %s\n\tDuration:\t %d\n\t", this.subject, this.duration);
    }

    @Override
    public int calculateScore() {
        return gradeEssay();
    }
}
