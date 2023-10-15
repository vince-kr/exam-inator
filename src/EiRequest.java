import java.util.ArrayList;
import java.util.regex.Pattern;

public class EiRequest {

    private final String requestHead;
    private final ArrayList<EiMenuItem> menuItems;
    private final Pattern matchResponse;
    private String prompt;

    public EiRequest(
            String requestHead,
            String prompt,
            ArrayList<EiMenuItem> menuItems,
            Pattern matchResponse) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.menuItems = menuItems;
        this.matchResponse = matchResponse;
    }

    public Pattern getMatchResponse() {
        return matchResponse;
    }

    public String toString() {
        StringBuilder menu = new StringBuilder();
        for (EiMenuItem menuItem : menuItems) {
            menu.append(menuItem.selector() + "\t" + menuItem.description() + "\n");
        }
        return this.requestHead + "\n\n" + menu + "\n" + this.prompt;
    }
}