import java.util.HashMap;
import java.util.regex.Pattern;

/*
TODO
There are different types of requests!
- "main" gives a menu, a prompt, asks for a one character response, and routes to another
    menu based on that
- "add-student" gives a prompt, asks for a longer response, and takes some action (storing
    the name) before routing to parent
- "list-students" only provides some information and does not ask for anything before
    routing to parent

INHERITAAANCE
 */

abstract class EiRequest {
    String requestHead;
    String prompt;
    EiMenu menu;
    HashMap<String, String> forward;
    String parent;
    Pattern pattern;

    public boolean hasMenu() {
        return !menu.isEmpty();
    }

    public boolean hasPrompt() {
        return !prompt.isEmpty();
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

    public String getParent() {
        return parent;
    }

    public String toString() {
        return this.requestHead + "\n\n" + this.menu + "\n" + this.prompt;
    }
}