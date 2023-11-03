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

    @Override
    public int compareTo(ExamResult other) {
        return this.score - other.score;
    }

    public String toString(int[] columnWidths) {
        StringBuilder fieldValues = new StringBuilder();

        fieldValues.append(standardise(String.valueOf(exam.getExamId()), columnWidths[0]));
        fieldValues.append(standardise(exam.getSubject(), columnWidths[1]));
        fieldValues.append(standardise(String.valueOf(exam.getDuration()), columnWidths[2]));
        fieldValues.append(standardise(exam.getType(), columnWidths[3]));
        fieldValues.append(standardise(String.valueOf(exam.calculateScore()), columnWidths[4]));

        return fieldValues.toString();
    }
}