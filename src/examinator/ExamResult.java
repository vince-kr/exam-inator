package examinator;

import examinator.exam.Scorable;
import examinator.student.Student;

public class ExamResult implements Comparable<ExamResult> {
    Student student;
    Scorable exam;
    int score;

    public ExamResult(Student student, Scorable exam) {
        this.student = student;
        this.exam = exam;
        this.score = exam.calculateScore();
    }

    @Override
    public int compareTo(ExamResult other) {
        return this.score - other.score;
    }

    public String toString() {
        return "Student:\t" + student.getStudentName() + "\n" +
                "Exam:\t\t" + exam + "\n" +
                "Score:\t\t" + score;
    }
}
