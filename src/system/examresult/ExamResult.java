package system.examresult;

import system.exam.Exam;
import system.student.Student;

public class ExamResult {
    Student student;
    Exam exam;
    int score;

    public ExamResult(Student student, Exam exam, int score) {
        this.student = student;
        this.exam = exam;
        this.score = score;
    }

    public String toString() {
        return "Yes";
    }
}
