package system.examresult;

import system.exam.Exam;
import system.student.Student;

public class ExamResult implements Comparable {
    Student student;
    Exam exam;
    int score;

    public ExamResult(Student student, Exam exam, int score) {
        this.student = student;
        this.exam = exam;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ExamResult))
            return 0;
        ExamResult other = (ExamResult) o;
        return this.score - other.score;
    }

    public String toString() {
        return "Yes";
    }
}
