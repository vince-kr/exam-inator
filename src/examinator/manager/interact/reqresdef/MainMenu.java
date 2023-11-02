package examinator.manager.interact.reqresdef;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;
import util.io.UserInput;

import static util.io.UserInput.getValidUserInput;

public class MainMenu implements Interaction {
    String header = "MAIN MENU\n";
    Menu menuOptions = new Menu();
    String prompt = "Please enter the letter or number of your choice: ";
    String responsePattern = "^[aelx1-4]$";

    public MainMenu() {
        menuOptions.add(new MenuItem("Add a student", "a"));
        menuOptions.add(new MenuItem("Store an exam result", "e"));
        menuOptions.add(new MenuItem("List all students", "l"));
        menuOptions.add(new MenuItem("Exit", "x"));
    }

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(menuOptions);

        String userInput = UserInput.getValidUserInput(prompt, responsePattern);

        return switch (userInput) {
            case "a", "1" ->
                    "add-student";
            case "e", "2" ->
                    "record-exam-result";
            case "l", "3" ->
                    "list-students";
            default ->
                    null;
        };
    }
}
