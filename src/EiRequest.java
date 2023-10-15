import java.util.HashMap;
import java.util.regex.Pattern;

public class EiRequest {

    private final String requestHead;
    private final String prompt;
    private final EiMenu menu;
    private final HashMap<String, String> forward;
    private final Pattern pattern;

    public EiRequest(
            String requestHead,
            String prompt,
            EiMenu menu,
            HashMap<String, String> forward,
            Pattern pattern) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.menu = menu;
        this.forward = forward;
        this.pattern = pattern;
    }

    public EiRequest(
            String requestHead,
            String prompt,
            Pattern pattern) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.menu = new EiMenu();
        this.forward = new HashMap<>();
        this.pattern = pattern;
    }
    public boolean hasMenu() {
        return !menu.isEmpty();
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getRequestHead() {
        return requestHead;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getMenu() {
        return menu.toString();
    }

    public HashMap<String, String> getForward() {
        return forward;
    }

    public String toString() {
        return this.requestHead + "\n\n" + this.menu + "\n" + this.prompt;
    }
}