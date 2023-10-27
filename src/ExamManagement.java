import system.exam.Essay;
import system.exam.Exam;
import system.exam.ExamException;
import system.exam.MultipleChoice;
import system.student.Student;
import system.student.StudentException;
import util.io.Files;

import java.util.ArrayList;
import java.util.Arrays;

class ExamManagement {
    Essay testOne;
    MultipleChoice testTwo;
    Student testStudent;

    public ExamManagement() {
        ArrayList<Exam> testExams = testExams();
        for (Exam exam : testExams)
            System.out.println(exam);

        try {
            testStudent = new Student(42, "Vince");
        } catch (
                StudentException se) {
            System.out.println("ERROR - " + se.getMessage());
        }

        System.out.println(testStudent.printSummaryResult());
    }

    private ArrayList<Exam> testExams() {
        ArrayList<Exam> testExams = new ArrayList<>();
        String[] essayAnswers = loadEssayAnswers();

        try {
            testExams.add(new Essay(
                    4,
                    "Software dev",
                    90,
                    "What is it all about, when you get right down to it?",
                    96,
                    94,
                    500
            ));
            testExams.add(new MultipleChoice(
                    5,
                    "Bird quiz",
                    60,
                    12,
                    15
            ));
            testExams.add(new MultipleChoice(
                    12, "Software processes", 60, 28, 30));
            testExams.add(new MultipleChoice(
                    13, "Algorithms", 120, 9, 50));
            testExams.add(new Essay(
                    14, "Structural modelling", 60, essayAnswers[0], 72, 89, 1000));
        } catch (
                ExamException ee) {
            System.out.println("ERROR - " + ee.getMessage());
        }

        return testExams;
    }

    private String[] loadEssayAnswers() {
        String delim = "=====";
        String essayAnswers = Files.readAsset("essay_answers.txt");
        return essayAnswers.split(delim);
    }
}
