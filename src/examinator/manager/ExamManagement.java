package examinator.manager;

import examinator.ExamResult;
import examinator.exam.Essay;
import examinator.exam.ExamException;
import examinator.exam.MultipleChoice;
import examinator.exam.Scorable;
import examinator.manager.interact.UserInteractor;
import examinator.student.Student;
import examinator.student.StudentException;
import util.io.Files;

import java.util.ArrayList;

public class ExamManagement {
    ArrayList<Scorable> allExams = new ArrayList<>();
    ArrayList<Student> allStudents = new ArrayList<>();

    public ExamManagement() {
        // Create ArrayLists of students, exams, and exam results

        // Create 3 students
        ArrayList<Student> testStudents = loadTestStudents();

        // Create 5 exams
        ArrayList<Scorable> testExams = loadTestExams();

        // Create 5 exam results by combining the lists of students and exams
        ArrayList<ExamResult> testResults = new ArrayList<>();
        for (int i = 0; i < testExams.size(); i++) {
            Student student = testStudents.get(i/2);
            Scorable exam = testExams.get(i);
            testResults.add(new ExamResult(student, exam, exam.calculateScore()));
        }

        // Print the exam results
        for (ExamResult result : testResults) {
            System.out.println(result);
        }
    }

    private ArrayList<Scorable> loadTestExams() {
        // Helper method to create five Exam objects
        ArrayList<Scorable> testExams = new ArrayList<>();

        try {
            testExams.add(new Essay(
                    4, "Software dev", 90, loadEssayAnswer("short"), 96, 94, 500
            ));
            testExams.add(new MultipleChoice(
                    5, "Bird quiz", 60, 12, 15
            ));
            testExams.add(new MultipleChoice(
                    12, "Software processes", 60, 28, 30));
            testExams.add(new MultipleChoice(
                    13, "Algorithms", 120, 9, 50));
            testExams.add(new Essay(
                    14, "Structural modelling", 60, loadEssayAnswer("long"), 72, 89, 1000));
        } catch (ExamException ee) {
            System.out.println("ERROR - " + ee.getMessage());
        }

        return testExams;
    }

    private String loadEssayAnswer(String type) {
        // Helper method to load essay answers from persistence
        return Files.readAsset(type + "_essay.txt");
    }

    private ArrayList<Student> loadTestStudents() {
        // Helper method to create three Student objects
        ArrayList<Student> testStudents = new ArrayList<>();

        try {
            testStudents.add(new Student(69, "Vince"));
            testStudents.add(new Student(70, "Cindy"));
            testStudents.add(new Student(71, "Patrick"));
        } catch (StudentException se) {
            System.out.println("ERROR - " + se.getMessage());
        }

        return testStudents;
    }

    public UserInteractor createUserInteractor() {
        return new UserInteractor();
    }
}
