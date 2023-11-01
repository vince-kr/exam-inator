package examinator.manager;

import examinator.ExamResult;
import examinator.exam.Essay;
import examinator.exam.ExamException;
import examinator.exam.MultipleChoice;
import examinator.exam.Scorable;
import examinator.student.Student;
import examinator.student.StudentException;
import util.io.Files;

import java.util.ArrayList;

public abstract class TestObjectGenerator {

    public static ArrayList<Student> loadTestStudents() {
        // Helper method to create three Student objects
        ArrayList<Student> testStudents = new ArrayList<>();

        try {
            testStudents.add(new Student(69, "Vince"));
            testStudents.add(new Student(70, "Cindy"));
            testStudents.add(new Student(71, "Patrick"));
        } catch (
                StudentException se) {
            System.out.println("ERROR - " + se.getMessage());
        }

        return testStudents;
    }

    public static ArrayList<Scorable> loadTestExams() {
        // Helper method to create five Exam objects
        ArrayList<Scorable> testExams = new ArrayList<>();

        try {
            testExams.add(new Essay(
                    4, "Software dev", 90, loadEssayAnswer("short"), 96, 94, 500
            ));
            testExams.add(new Essay(
                    14, "Structural modelling", 60, loadEssayAnswer("long"), 72, 89, 1000
            ));
            testExams.add(new MultipleChoice(
                    5, "Bird quiz", 60, 12, 15
            ));
            testExams.add(new MultipleChoice(
                    12, "Software processes", 60, 28, 30
            ));
            testExams.add(new MultipleChoice(
                    13, "Algorithms", 120, 9, 50
            ));
        } catch (
                ExamException ee) {
            System.out.println("ERROR - " + ee.getMessage());
        }

        return testExams;
    }

    private static String loadEssayAnswer(String type) {
        // Helper method to load essay answers from persistence
        return Files.readAsset(type + "_essay.txt");
    }

    public static ArrayList<ExamResult> createExamResults(ArrayList<Student> students, ArrayList<Scorable> exams) {
        ArrayList<ExamResult> examResults = new ArrayList<>();

        for (int i = 0; i < exams.size(); i++) {
            Student student = students.get(i / 2);
            Scorable exam = exams.get(i);
            examResults.add(new ExamResult(student, exam, exam.calculateScore()));
        }

        return examResults;
    }
}