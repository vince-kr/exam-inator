package examinator.manager.interact;

import examinator.manager.ExamManagement;
import util.io.UserInput;

public class MainMenu implements Interaction {
    // The main menu at the root of user interaction
    String header = "MAIN MENU\n";
    Menu menu = new Menu();
    String prompt = "Please enter the letter or number of your choice: ";
    // Match any selector or menu item number exactly once
    String responsePattern = "^[aelorsxAELORSX1-7]$";

    public MainMenu() {
        // Populate the menu field with descriptive options
        menu.add(new MenuItem("Add a student", "a"));
        menu.add(new MenuItem("Store an exam result", "e"));
        menu.add(new MenuItem("List all students", "l"));
        menu.add(new MenuItem("Examine one student", "o"));
        menu.add(new MenuItem("List all results", "r"));
        menu.add(new MenuItem("Load sample data", "s"));
        menu.add(new MenuItem("Exit", "x"));
    }

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(menu);

        String userInput = UserInput.getValidString(prompt, responsePattern);

        return switch (userInput) {
            // Return a reference to an Interaction loaded in ExamManagement
            case "a", "A", "1" ->
                    "add-student";
            case "e", "E", "2" ->
                    "record-exam-result";
            case "l", "L", "3" ->
                    "list-students";
            case "o", "O", "4" ->
                    "examine-student";
            case "r", "R", "5" ->
                "list-results";
            case "s", "S", "6" ->
                    "load-sample-data";
            default ->
                    null;
        };
    }
}
