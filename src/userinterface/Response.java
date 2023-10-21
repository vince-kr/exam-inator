package userinterface;

public abstract class Response {
    private String nextInteraction;
    private boolean finished;

    String getNextInteraction() {
        return nextInteraction;
    }

    boolean getFinished() {
        return finished;
    }
}
