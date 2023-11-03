package examinator.manager.interact;

import examinator.manager.ExamManagement;
import util.io.UserInput;

import static util.io.UserInput.getValidStringInput;

public class MainMenu implements Interaction {
    String header = "MAIN MENU\n";
    Menu menu = new Menu();
    String prompt = "Please enter the letter or number of your choice: ";
    String responsePattern = "^[aelosx1-6]$";

    public MainMenu() {
        menu.add(new MenuItem("Add a student", "a"));
        menu.add(new MenuItem("Store an exam result", "e"));
        menu.add(new MenuItem("List all students", "l"));
        menu.add(new MenuItem("Examine one student", "o"));
        menu.add(new MenuItem("Load sample data", "s"));
        menu.add(new MenuItem("Exit", "x"));
    }

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(menu);

        String userInput = getValidStringInput(prompt, responsePattern);

        return switch (userInput) {
            case "a", "1" ->
                    "add-student";
            case "e", "2" ->
                    "record-exam-result";
            case "l", "3" ->
                    "list-students";
            case "o", "4" ->
                    "examine-student";
            case "s", "5" ->
                    "load-sample-data";
            default ->
                    null;
        };
    }
}
