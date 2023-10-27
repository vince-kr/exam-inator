package test;

import system.exam.Essay;
import system.exam.Exam;
import system.exam.ExamException;
import system.exam.MultipleChoice;
import system.student.Student;
import system.student.StudentException;
import util.io.Files;

import java.util.ArrayList;

public class ExamManagement {
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

    private EssayDefinition[] loadEssayExams() {
        String rawEssayDefinitions = Files.readAsset("essay_defs.csv");
        String[] edLines = rawEssayDefinitions.split("\n");
        int countEdValues = edLines.length;

        EssayDefinition[] edRecords = new EssayDefinition[countEdValues];

        for (int i = 0; i < countEdValues; i++) {
            String[] edValues = edLines[i].split(",");
            int examId = Integer.parseInt(edValues[0]);
            String subject = edValues[1];
            int duration = Integer.parseInt(edValues[2]);
            String essayAnswer = edValues[3];
            int grammar = Integer.parseInt(edValues[4]);
            int content = Integer.parseInt(edValues[5]);
            int wordLimit = Integer.parseInt(edValues[6]);
            edRecords[i] = new EssayDefinition(examId, subject, duration, essayAnswer, grammar, content, wordLimit);
        }

        return edRecords;
    }
}
