import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UserInteractor {
    private boolean isFinished;
    private EiRequest currentRequest;
    private HashMap<String, EiRequest> allRequests;

    public UserInteractor() {
        allRequests = loadEiRequests();
        currentRequest = allRequests.get("main");
    }

    public void completeRequestResponseCycle() {
        String response;
        System.out.println(currentRequest.getRequestHead());
        if (currentRequest.hasMenu())
            System.out.println(currentRequest.getMenu());
        if (currentRequest.hasPrompt()) {
            response = getValidResponse(currentRequest.getPrompt());
            this.currentRequest = allRequests.get(currentRequest.getForward().get(response));
        } else {
            this.currentRequest = allRequests.get(currentRequest.getParent());
        }
    }

    private String getValidResponse(String prompt) {
        Scanner userIn = new Scanner(System.in);
        Matcher matcher;

        System.out.print(prompt);
        String response = userIn.nextLine();
        matcher = currentRequest.getPattern().matcher(response);

        while (!matcher.matches()) {
            System.out.println("That option is not valid. Please try again.");
            System.out.print(prompt);
            response = userIn.nextLine();
            matcher = currentRequest.getPattern().matcher(response);
        }
        return response;
    }

    private HashMap<String, EiRequest> loadEiRequests() {
        HashMap<String, EiRequest> allRequests = new HashMap<>();

        EiMenu mainMenu = new EiMenu() {
            {
                add(new EiMenuItem("Add a student", "a"));
                add(new EiMenuItem("List all students", "l"));
                add(new EiMenuItem("Display one student", "d"));
                add(new EiMenuItem("Store an exam result", "e"));
                add(new EiMenuItem("Load sample data", "s"));
            }
        };

        HashMap<String, String> forward = new HashMap<>();
        forward.put("a", "add-student");
        forward.put("l", "list-students");

        allRequests.put("main", new EiMenuSelection(
                "MAIN MENU",
                "Please enter the letter (case-insensitive) or number for your choice: ",
                mainMenu,
                forward,
                "main",
                Pattern.compile("^[aldes1-5]$", Pattern.CASE_INSENSITIVE)
        ));
        allRequests.put("add-student", new EiDataInput(
                "ADD A STUDENT",
                "Please enter the full name of a student." +
                        "The name should be between 2 and 30 characters long: ",
                "main",
                Pattern.compile("^[a-zA-Z ]{2,30}$")
        ));
        allRequests.put("list-students", new EiDataOutput(
                "LIST ALL STUDENTS",
                "main"
        ));

        return allRequests;
    }

    public boolean isFinished() {
        return isFinished;
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

- Required pattern that the user's response must match e.g.
^[aldes1-5]$
The method will continue to ask the user for a response until it matches the pattern

The RESPONSE consists of:
- The user's response as a string or char e.g.
'a'

- The result of passing this response to a method whose task is to parse the response and
    take some appropriate action, which should always include setting nextMenu
*/