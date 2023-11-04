package examinator;

import examinator.exam.Exam;
import examinator.exam.Scorable;
import examinator.student.Student;

import static util.format.StringFormat.standardise;

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
        return other.getScore() - this.score;
    }

    @Override
    public String toString() {
        return standardise(student.getStudentName(), 36) +
                standardise(exam.getSubject(), 36) +
                exam.calculateScore();
    }

    public String summaryResult() {
        return standardise(exam.getSubject(), 36) + getScore();
    }

    public String detailedResult(int[] columnWidths) {
        return standardise(String.valueOf(exam.getExamId()), columnWidths[0]) +
                standardise(exam.getSubject(), columnWidths[1]) +
                standardise(String.valueOf(exam.getDuration()), columnWidths[2]) +
                standardise(exam.getType(), columnWidths[3]) +
                standardise(String.valueOf(exam.calculateScore()), columnWidths[4]);
    }
}