package examinator.manager.interact;

import examinator.manager.ExamManagement;

import java.util.Collections;

import static util.io.UserInput.getValidStringInput;

public class SortResultsMenu implements Interaction {
    String header = "SORT RESULTS\n";
    Menu menu = new Menu();
    String prompt = "Please choose a sort option: ";
    String responsePattern = "^[hlm1-3]$";

    public SortResultsMenu() {
        menu.add(new MenuItem("Sort high to low", "h"));
        menu.add(new MenuItem("Sort low to high", "l"));
        menu.add(new MenuItem("Back to main menu", "m"));
    }

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(menu);

        String userInput = getValidStringInput(prompt, responsePattern);

        return switch (userInput) {
            case "h", "1" -> {
                Collections.sort(exMan.getExamResults());
                yield "list-results";
            }
            case "l", "2" -> {
                exMan.getExamResults().sort(Collections.reverseOrder());
                yield "list-results";
            }
            default -> "main";
        };
    }
}
