package examinator.manager.interact;

import java.util.ArrayList;

class Menu extends ArrayList<MenuItem> {
    public String toString() {
        StringBuilder menu = new StringBuilder();
        for (MenuItem menuItem : this) {
            String fmtItem = menuItem.selector() + "\t" + menuItem.description() + "\n";
            menu.append(fmtItem);
        }
        return menu.toString();
    }
}

record MenuItem(String description, String selector) {}