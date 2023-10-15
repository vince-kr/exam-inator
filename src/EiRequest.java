import java.util.regex.Pattern;

public class EiRequest {

    private final String requestHead;
    private final EiMenu menu;
    private final Pattern pattern;
    private final String prompt;

    public EiRequest(
            String requestHead,
            String prompt,
            EiMenu menu,
            Pattern pattern) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.menu = menu;
        this.pattern = pattern;
    }

    public EiRequest(
            String requestHead,
            String prompt,
            Pattern pattern) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.menu = new EiMenu();
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

    public String toString() {
        return this.requestHead + "\n\n" + this.menu + "\n" + this.prompt;
    }
}