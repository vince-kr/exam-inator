package examinator.manager.interact.reqresdef;

import examinator.manager.interact.Interaction;
import java.util.Scanner;

public class MainMenu implements Interaction {
    String header = "MAIN MENU\n";
    Menu menuOptions = new Menu();
    String prompt = "Please enter the letter or number of your choice: ";

    public MainMenu() {
        menuOptions.add(new MenuItem("Add a student", "a"));
        menuOptions.add(new MenuItem("Store an exam result", "e"));
    }

    @Override
    public String transmitAndReceive() {
        System.out.println(header);
        System.out.println(menuOptions);

        String userInput = getValidInput(prompt);

        return switch (userInput) {
            case "a", "1" ->
                    "add-student";
            case "e", "2" ->
                    "record-exam-result";
            default ->
                    null;
        };
    }

    private static String getValidInput(String prompt) {
        Scanner userIn = new Scanner(System.in);
        String responsePattern = "^[ae12]$";

        System.out.print(prompt);
        String userInput = userIn.nextLine();
        while (!userInput.matches(responsePattern)) {
            System.out.println("WARNING - " + userInput + " is not valid!");
            System.out.println(prompt);
            userInput = userIn.nextLine();
        }
        return userInput;
    }
}
