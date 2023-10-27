package system.student;

import system.exam.Exam;

import java.util.ArrayList;

public class Student implements Printable {
    int studentId;
    String studentName;
    ArrayList<Exam> examsTaken = new ArrayList<>();

    public Student(int studentId, String studentName) throws StudentException {
        if (studentName.length() < 2 || studentName.length() > 30) {
            throw new StudentException("Student name must be between 2 and 30 characters!");
        }

        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public String printSummaryResult() {
        // Introduce the student, then:
        // say number of exams taken (length of Exams field); then subject, score all on 1 line
        StringBuilder summaryResult = new StringBuilder();
        summaryResult.append(studentSummary());
        summaryResult.append(examsTaken.size() + "\n");
        for (Exam exam : examsTaken) {
            summaryResult.append(exam + "\t" + exam.calculateScore() + "\n");
        }
        return summaryResult.toString();
    }

    @Override
    public String printDetailedResults() {
        // Introduce the student, then:
        // say ID, subject, duration, type, score on a nicely spaced line
        return null;
    }

    private String studentSummary() {
        StringBuilder studentSummary = new StringBuilder();
        String delim = "----------------------------------------------------------------\n";
        studentSummary.append(delim);
        studentSummary.append("\tName: " + String.format("%1$-" + 36 + "s", studentName));
        studentSummary.append("ID: " + studentId + "\n");
        studentSummary.append(delim);
        return studentSummary.toString();
    }
}
