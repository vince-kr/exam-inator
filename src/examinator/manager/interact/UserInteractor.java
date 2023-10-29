package examinator.manager.interact;

import examinator.manager.interact.reqresdef.GetStudentID;
import examinator.manager.interact.reqresdef.MainMenu;
import examinator.manager.interact.reqresdef.RecordExamResult;

import java.util.HashMap;

public class UserInteractor {
    private Interaction currentInteraction;
    private final HashMap<String, Interaction> allInteractions;
    private boolean isFinished;

    public UserInteractor() {
        allInteractions = loadInteractions();
        currentInteraction = allInteractions.get("main");
    }

    public void completeInteractionCycle() {
        String nextInteractionReference = currentInteraction.transmitAndReceive();
        currentInteraction = allInteractions.get(nextInteractionReference);
        isFinished = (currentInteraction == null);
    }

    private HashMap<String, Interaction> loadInteractions() {
        HashMap<String, Interaction> allRequests = new HashMap<>();

        allRequests.put("main", new MainMenu());
        allRequests.put("record-exam-result", new RecordExamResult());
        allRequests.put("add-student-1", new GetStudentID());

        return allRequests;
    }

    public boolean userIsFinished() {
        return isFinished;
    }
}
