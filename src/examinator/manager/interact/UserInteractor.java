package examinator.manager.interact;

import examinator.manager.interact.reqresdef.MainMenu;
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

        return allRequests;
    }

    public boolean userIsFinished() {
        return isFinished;
    }
}
