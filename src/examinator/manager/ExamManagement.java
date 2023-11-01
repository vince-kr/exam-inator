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

import static examinator.manager.TestObjectGenerator.*;

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
        ArrayList<ExamResult> testResults = createExamResults(testStudents, testExams);

        // Print the exam results
        for (ExamResult result : testResults) {
            System.out.println(result);
        }
    }

    public UserInteractor createUserInteractor() {
        return new UserInteractor();
    }
}