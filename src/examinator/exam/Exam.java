package examinator.exam;

import static util.format.StringFormat.standardise;

public abstract class Exam implements Scorable {
    int examId;
    String subject;
    int duration;

    public Exam(int examId, String subject, int duration) throws ExamException {
        if (duration < 30 || duration > 180) {
            throw new ExamException("Duration should be between 30 and 180 minutes!");
        }
        this.examId = examId;
        this.subject = subject;
        this.duration = duration;
    }

    public int getExamId() {
        return examId;
    }

    public String getSubject() {
        return subject;
    }

    public int getDuration() {
        return duration;
    }

    public abstract String getType();

    public String toString() {
        return standardise(subject, 36);
    }
}
