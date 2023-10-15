import java.util.ArrayList;

public class EiMenu extends ArrayList<EiMenuItem> {
    public String toString() {
        StringBuilder menu = new StringBuilder();
        for (EiMenuItem menuItem : this) {
            String fmtItem = menuItem.selector() + "\t" + menuItem.description() + "\n";
            menu.append(fmtItem);
        }
        return menu.toString();
    }
}