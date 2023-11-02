package examinator.manager;

import examinator.ExamResult;
import examinator.exam.Scorable;
import examinator.manager.interact.Interaction;
import examinator.manager.interact.reqresdef.AddStudent;
import examinator.manager.interact.reqresdef.ListStudents;
import examinator.manager.interact.reqresdef.MainMenu;
import examinator.manager.interact.reqresdef.RecordExamResult;
import examinator.student.Student;

import java.util.ArrayList;
import java.util.HashMap;

import static examinator.manager.TestObjectGenerator.*;

public class ExamManagement {
    ArrayList<Scorable> allExams = new ArrayList<>();
    ArrayList<Student> allStudents = new ArrayList<>();
    private Interaction currentInteraction;
    private final HashMap<String, Interaction> allInteractions;
    boolean isFinished;

    public ExamManagement() {
        allInteractions = loadInteractions();
        currentInteraction = allInteractions.get("main");
    }

    private HashMap<String, Interaction> loadInteractions() {
        HashMap<String, Interaction> allRequests = new HashMap<>();

        allRequests.put("main", new MainMenu());
        allRequests.put("record-exam-result", new RecordExamResult());
        allRequests.put("add-student", new AddStudent());
        allRequests.put("list-students", new ListStudents());

        return allRequests;
    }

    public void runTests() {
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

    public void completeInteractionCycle() {
        System.out.println();
        String nextInteractionReference = currentInteraction.transmitAndReceive(this);
        currentInteraction = allInteractions.get(nextInteractionReference);
        isFinished = (currentInteraction == null);
    }

    public boolean userIsFinished() {
        return isFinished;
    }

    public String getAllStudents() {
        StringBuilder allStudentsFmt = new StringBuilder();
        for (Student student : allStudents) {
            allStudentsFmt.append(student).append("\n");
        }
        return allStudentsFmt.toString();
    }

    public void addStudent(Student student) {
        allStudents.add(student);
    }
    public void addExam(Scorable exam) {
        allExams.add(exam);
    }

}