import java.util.HashMap;

public class UserInteractor {
    private boolean isFinished;
    private UserMenu nextMenu;
    private HashMap<String, UserMenu> allMenus;

    public boolean isFinished() {
        return isFinished;
    }

    public void printNextMenu() {
        System.out.println(nextMenu);
    }
}

/*
Each interaction is a REQUEST and a RESPONSE
The REQUEST consists of:
- Optional list of menu items (each has one identifier) e.g.
a   Add a student
l   List all students
d   Display one student
e   Store an exam result
s   Load sample data

- Required prompt asking for input e.g.
Please enter the letter (case-insensitive) or number for your choice:

- Some pattern that the user's response must match e.g.
^[aldes1-9]$
The method will continue to ask the user for a response until it matches the pattern

The RESPONSE consists of:
- The user's response as a string or char e.g.
'a'

- The result of passing this response to a method whose task is to parse the response and
    take some appropriate action, which should always include setting nextMenu
*/