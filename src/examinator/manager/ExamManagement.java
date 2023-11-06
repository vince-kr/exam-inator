package examinator.manager;

import examinator.ExamResult;
import examinator.exam.Scorable;
import examinator.manager.interact.*;
import examinator.student.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamManagement {
    ArrayList<Student> allStudents = new ArrayList<>();
    // Maintain two collections for ExamResults
    // allResultsInput contains all ExamResult objects in the order they are received
    ArrayList<ExamResult> allResultsInput = new ArrayList<>();
    // allResultsOutput contains ExamResults affected by sort and/or filter
    ArrayList<ExamResult> allResultsOutput = new ArrayList<>();

    // Interaction types form the backbone of interacting with the user through CLI
    private Interaction currentInteraction;
    private final HashMap<String, Interaction> allInteractions;
    boolean isFinished;

    public ExamManagement() {
        /*
        Interactions represent menus, prompts, or simple data displays. Each is defined in
        its own class, and each class implements the Interaction interface.
        */
        allInteractions = loadInteractions();
        currentInteraction = allInteractions.get("main");
    }

    private HashMap<String, Interaction> loadInteractions() {
        // Match String references to instances of Interaction classes
        HashMap<String, Interaction> allInteractions = new HashMap<>();

        allInteractions.put("main", new MainMenu());
        allInteractions.put("record-exam-result", new RecordExamResult());
        allInteractions.put("add-student", new AddStudent());
        allInteractions.put("list-students", new ListStudents());
        allInteractions.put("examine-student", new ExamineStudent());
        allInteractions.put("list-results", new ListResults());
        allInteractions.put("sort-options", new SortResultsMenu());
        allInteractions.put("load-sample-data", new LoadSamples());

        return allInteractions;
    }

    public void completeInteractionCycle() {
        /*
        Call transmitAndReceive to interact with the user, and get a reference to the next
        interaction back. Use this reference to look up & update the currentInteraction
        field. Finally, if no interaction could be found (which should only happen when the
        user chooses to exit), set isFinished to true.
        */
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
        // New results are added to both Input and Output collections
        allResultsInput.add(new ExamResult(student, exam));
        allResultsOutput.add(new ExamResult(student, exam));
    }

    public ArrayList<ExamResult> getExamResults() {
        // The getter always returns the Output collection
        return allResultsOutput;
    }

    public void filterExamResultsOutput(String typeFilter) {
        /*
        In case a subset of the ExamResults is required (by type of exam) the Output collection
        is cleared, and then filled by iterating over the Input collection.
        */
        allResultsOutput.clear();

        for (ExamResult er : allResultsInput) {
            String type = er.getExam().getType();
            if (type.equals(typeFilter))
                allResultsOutput.add(er);
        }
    }

    public void resetFilter() {
        // Assign a fresh copy of the Input collection to Output to reset any sorts/filters
        allResultsOutput = new ArrayList<>(allResultsInput);
    }
}