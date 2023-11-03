package examinator.manager;

import examinator.ExamResult;
import examinator.exam.Scorable;
import examinator.manager.interact.*;
import examinator.student.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamManagement {
    ArrayList<Student> allStudents = new ArrayList<>();
    ArrayList<ExamResult> allResults = new ArrayList<>();
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
        allRequests.put("load-sample-data", new LoadSamples());

        return allRequests;
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

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public void addStudent(Student student) {
        allStudents.add(student);
    }

    public void addResult(Student student, Scorable exam) {
        allResults.add(new ExamResult(student, exam));
    }
}