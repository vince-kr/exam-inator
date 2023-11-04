package examinator;

import examinator.exam.Exam;
import examinator.exam.Scorable;
import examinator.student.Student;
import util.format.StringFormat;

public class ExamResult implements Comparable<ExamResult> {

    Student student;
    Exam exam;
    int score;

    public ExamResult(Student student, Scorable exam) {
        this.student = student;
        this.exam = (Exam) exam;
        this.score = exam.calculateScore();
    }

    public Exam getExam() {
        return exam;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(ExamResult other) {
        return Integer.compare(other.getScore(), this.score);
    }

    @Override
    public String toString() {
        return StringFormat.standardise(student.getStudentName(), 36) +
                StringFormat.standardise(exam.getSubject(), 36) +
                exam.calculateScore();
    }

    public String summaryResult() {
        return StringFormat.standardise(exam.getSubject(), 36) + getScore();
    }

    public String detailedResult(int[] columnWidths) {
        return StringFormat.standardise(String.valueOf(exam.getExamId()), columnWidths[0]) +
                StringFormat.standardise(exam.getSubject(), columnWidths[1]) +
                StringFormat.standardise(String.valueOf(exam.getDuration()), columnWidths[2]) +
                StringFormat.standardise(exam.getType(), columnWidths[3]) +
                StringFormat.standardise(String.valueOf(exam.calculateScore()), columnWidths[4]);
    }
}