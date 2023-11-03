package examinator.exam;

abstract class Exam implements Scorable {
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

    public int getDuration() {
        return duration;
    }

    public String toString() {
        String fmtSubject;

        if (subject.length() > 35) {
            fmtSubject = subject.substring(0, 32) + "...";
        } else {
            fmtSubject = subject;
        }

        return String.format("%1$-" + 36 + "s", fmtSubject);
    }
}
