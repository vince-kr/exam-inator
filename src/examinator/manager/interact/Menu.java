package examinator.manager.interact;

import java.util.ArrayList;

class Menu extends ArrayList<MenuItem> {
    // Just an ArrayList of MenuItem objects but with a custom toString
    public String toString() {
        StringBuilder menuAsString = new StringBuilder();
        for (MenuItem menuItem : this) {
            String fmtItem = menuItem.selector() + "\t" + menuItem.description() + "\n";
            menuAsString.append(fmtItem);
        }
        return menuAsString.toString();
    }
}

record MenuItem(String description, String selector) {}