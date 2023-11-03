package examinator.manager;

import examinator.exam.Essay;
import examinator.exam.ExamException;
import examinator.exam.MultipleChoice;
import examinator.exam.Scorable;
import examinator.student.Student;
import examinator.student.StudentException;
import util.io.Files;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class TestObjectGenerator {

    public static void loadSampleData(ExamManagement exMan) {
        // Create and add six students
        ArrayList<Student> testStudents = loadTestStudents();
        for (Student student : testStudents) {
            exMan.addStudent(student);
        }

        // Assign 15 exams to random students
        for (Scorable exam : loadTestExams()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, 6);
            Student assignee = testStudents.get(randomIndex);
            assignee.addExam(exam);
            exMan.addResult(assignee, exam);
        }
    }

    private static ArrayList<Student> loadTestStudents() {
        ArrayList<Student> testStudents = new ArrayList<>();

        try {
            testStudents.add(new Student(101, "Lê Quang Liêm"));
            testStudents.add(new Student(102, "Hikaru Nakamura"));
            testStudents.add(new Student(103, "Judit Polgár"));
            testStudents.add(new Student(104, "Shakhriyar Mamedyarov"));
            testStudents.add(new Student(105, "Василь Михайлович Іванчук"));
            testStudents.add(new Student(106, "Alexandra Kosteniuk"));
        } catch (
                StudentException se) {
            System.out.println("ERROR - " + se.getMessage());
        }

        return testStudents;
    }

    private static ArrayList<Scorable> loadTestExams() {
        ArrayList<Scorable> testExams = new ArrayList<>();

        try {
            testExams.add(new Essay(
                    201, "History of chess", 180, loadEssayAnswer("short"), 82, 68, 600
            ));
            testExams.add(new Essay(
                    202, "Knowing Kasparov", 90, loadEssayAnswer("long"), 90, 88, 1000
            ));
            testExams.add(new Essay(
                    203, "Carlsen's career", 90, loadEssayAnswer("short"), 80, 55, 5200
            ));
            testExams.add(new Essay(
                    204, "Today's rising stars", 60, loadEssayAnswer("short"), 90, 92, 1250
            ));
            testExams.add(new Essay(
                    205, "Women in chess", 120, loadEssayAnswer("long"), 78, 84, 8800
            ));
            testExams.add(new MultipleChoice(
                    301, "Sicilian opening: beginner", 60, 29, 40
            ));
            testExams.add(new MultipleChoice(
                    302, "Sicilian opening: advanced", 60, 27, 40
            ));
            testExams.add(new MultipleChoice(
                    303, "The London system", 90, 48, 50
            ));
            testExams.add(new MultipleChoice(
                    304, "The French defence", 90, 32, 50
            ));
            testExams.add(new MultipleChoice(
                    305, "The Dutch defence", 90, 49, 50
            ));
            testExams.add(new MultipleChoice(
                    306, "The Caro-Kann: beginner", 60, 21, 40
            ));
            testExams.add(new MultipleChoice(
                    307, "The Caro-Kann: advanced", 60, 39, 50
            ));
            testExams.add(new MultipleChoice(
                    308, "Grünfeld Defence: beginner", 60, 12, 40
            ));
            testExams.add(new MultipleChoice(
                    309, "Endgame: bishop and knight", 120, 44, 50
            ));
            testExams.add(new MultipleChoice(
                    310, "Endgame: QR vs Q", 120, 6, 50
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

    /*
    private static ArrayList<ExamResult> createExamResults(ArrayList<Student> students, ArrayList<Scorable> exams) {
        ArrayList<ExamResult> examResults = new ArrayList<>();

        for (int i = 0; i < exams.size(); i++) {
            Student student = students.get(i / 2);
            Scorable exam = exams.get(i);
            examResults.add(new ExamResult(student, exam, exam.calculateScore()));
        }

        return examResults;
    }
     */
}