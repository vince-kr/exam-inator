package examinator.manager;

import examinator.ExamResult;
import examinator.exam.Scorable;
import examinator.manager.interact.*;
import examinator.student.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ExamManagement {
    ArrayList<Student> allStudents = new ArrayList<>();
    ArrayList<ExamResult> allResultsInput = new ArrayList<>();
    ArrayList<ExamResult> allResultsOutput = new ArrayList<>();
    private Interaction currentInteraction;
    private final HashMap<String, Interaction> allInteractions;
    boolean isFinished;

    public ExamManagement() {
        allInteractions = loadInteractions();
        currentInteraction = allInteractions.get("main");
    }

    private HashMap<String, Interaction> loadInteractions() {
        HashMap<String, Interaction> allInteractions = new HashMap<>();

        allInteractions.put("main", new MainMenu());
        allInteractions.put("record-exam-result", new RecordExamResult());
        allInteractions.put("add-student", new AddStudent());
        allInteractions.put("list-students", new ListStudents());
        allInteractions.put("examine-student", new ExamineStudent());
        allInteractions.put("list-results", new ListResults());
        allInteractions.put("load-sample-data", new LoadSamples());
        allInteractions.put("sort-options", new SortResultsMenu());
        allInteractions.put("print-student-list", new PrintStudentList());

        return allInteractions;
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
        allResultsInput.add(new ExamResult(student, exam));
        syncResultLists();
    }

    public ArrayList<ExamResult> getExamResults() {
        return allResultsOutput;
    }

    public void getExamResults(String typeFilter) {
        allResultsOutput = allResultsInput.stream()
                .filter(er -> er.getExam().getType().equals(typeFilter))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void syncResultLists() {
        allResultsOutput = allResultsInput;
    }
}