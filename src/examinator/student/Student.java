package examinator.student;

import examinator.ExamResult;
import examinator.exam.Scorable;

import java.util.ArrayList;

import static util.format.StringFormat.standardise;

public class Student implements Printable {
    int studentId;
    String studentName;
    ArrayList<Scorable> examsTaken = new ArrayList<>();

    public Student(int studentId, String studentName) throws StudentException {
        if (studentName.length() < 2 || studentName.length() > 30) {
            throw new StudentException("Student name must be between 2 and 30 characters!");
        }

        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addExam(Scorable exam) {
        examsTaken.add(exam);
    }

    @Override
    public String printSummaryResult() {
        // Introduce the student, then:
        // say number of exams taken (length of Exams field); then subject, score all on 1 line
        StringBuilder summaryResult = new StringBuilder();
        summaryResult.append(studentNameID());
        summaryResult.append("Exams taken: " + examsTaken.size() + "\n");
        summaryResult.append(standardise("SUBJECT", 36));
        summaryResult.append("SCORE\n");
        for (Scorable exam : examsTaken) {
            summaryResult.append(exam + " " + exam.calculateScore() + "\n");
        }
        return summaryResult.toString();
    }

    @Override
    public String printDetailedResults() {
        // Introduce the student, then:
        // say ID, subject, duration, type, score on a nicely spaced line
        int[] columnWidths = {12, 36, 12, 24, 24};
        StringBuilder detailedResult = new StringBuilder();
        detailedResult.append(studentNameID());
        detailedResult.append(headerLine(columnWidths));

        for (Scorable exam : examsTaken) {
            detailedResult.append(new ExamResult(this, exam).toString(columnWidths));
            detailedResult.append("\n");
        }

        return detailedResult.toString();
    }

    private String studentNameID() {
        String delim = "----------------------------------------------------------------\n";
        return delim +
                "\tName: " + String.format("%1$-" + 36 + "s", studentName) +
                "ID: " + studentId + "\n" +
                delim;
    }

    private String headerLine(int[] columnWidths) {
        StringBuilder headerLine = new StringBuilder();
        String[] headers = {"Exam ID", "Subject", "Duration", "Type", "Score"};

        for (int i = 0; i<columnWidths.length; i++) {
            headerLine.append(standardise(headers[i], columnWidths[i]));
        }
        headerLine.append("\n");

        return headerLine.toString();
    }

    public String toString() {
        return printSummaryResult();
    }
}
