package examinator.manager.interact.reqresdef;

import examinator.manager.interact.Interaction;

import static examinator.manager.interact.reqresdef.Validator.getValidInput;

public class MainMenu implements Interaction {
    String header = "MAIN MENU\n";
    Menu menuOptions = new Menu();
    String prompt = "Please enter the letter or number of your choice: ";
    String responsePattern = "^[ae12]$";

    public MainMenu() {
        menuOptions.add(new MenuItem("Add a student", "a"));
        menuOptions.add(new MenuItem("Store an exam result", "e"));
    }

    @Override
    public String transmitAndReceive() {
        System.out.println(header);
        System.out.println(menuOptions);

        String userInput = getValidInput(prompt, responsePattern);

        return switch (userInput) {
            case "a", "1" ->
                    "add-student";
            case "e", "2" ->
                    "record-exam-result";
            default ->
                    null;
        };
    }
}
