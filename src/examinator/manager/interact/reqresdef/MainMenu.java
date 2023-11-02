package examinator.manager.interact.reqresdef;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;
import util.io.UserInput;

import static util.io.UserInput.getValidUserInput;

public class MainMenu implements Interaction {
    String header = "MAIN MENU\n";
    Menu menu = new Menu();
    String prompt = "Please enter the letter or number of your choice: ";
    String responsePattern = "^[aelsx1-5]$";

    public MainMenu() {
        menu.add(new MenuItem("Add a student", "a"));
        menu.add(new MenuItem("Store an exam result", "e"));
        menu.add(new MenuItem("List all students", "l"));
        menu.add(new MenuItem("Load sample data", "s"));
        menu.add(new MenuItem("Exit", "x"));
    }

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(menu);

        String userInput = UserInput.getValidUserInput(prompt, responsePattern);

        return switch (userInput) {
            case "a", "1" ->
                    "add-student";
            case "e", "2" ->
                    "record-exam-result";
            case "l", "3" ->
                    "list-students";
            case "s", "4" ->
                    "load-sample-data";
            default ->
                    null;
        };
    }
}
