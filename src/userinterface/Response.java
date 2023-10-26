package userinterface;

public record Response (String nextInteraction, boolean finished) {
    public Response(String nextInteraction) {
        this(nextInteraction, false);
    }
    public Response() {
        this("main", false);
    }
}
