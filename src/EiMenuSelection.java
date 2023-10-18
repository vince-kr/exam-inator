import java.util.HashMap;
import java.util.regex.Pattern;

class EiMenuSelection extends EiRequest {
    public EiMenuSelection(
            String requestHead,
            String prompt,
            EiMenu menu,
            HashMap<String, String> forward,
            String parent,
            Pattern pattern) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.menu = menu;
        this.forward = forward;
        this.parent = parent;
        this.pattern = pattern;
    }
}
