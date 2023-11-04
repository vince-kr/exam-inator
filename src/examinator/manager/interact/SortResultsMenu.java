package examinator.manager.interact;

import examinator.manager.ExamManagement;
import util.io.UserInput;

import java.util.Collections;

public class SortResultsMenu implements Interaction {
    String header = "SORT RESULTS\n";
    Menu menu = new Menu();
    String prompt = "Please choose a sort option: ";
    String responsePattern = "^[hlaemxHLAEMX1-6]$";

    public SortResultsMenu() {
        menu.add(new MenuItem("Sort: high to low", "h"));
        menu.add(new MenuItem("Sort: low to high", "l"));
        menu.add(new MenuItem("Filter: all", "a"));
        menu.add(new MenuItem("Filter: only essays", "e"));
        menu.add(new MenuItem("Filter: only multiple choice", "m"));
        menu.add(new MenuItem("Back to main menu", "x"));
    }

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(menu);

        String userInput = UserInput.getValidString(prompt, responsePattern);

        return switch (userInput) {
            case "h", "H", "1" -> {
                Collections.sort(exMan.getExamResults());
                yield "list-results";
            }
            case "l", "L", "2" -> {
                Collections.sort(exMan.getExamResults(), Collections.reverseOrder());
                yield "list-results";
            }
            case "a", "A", "3" -> {
                exMan.resetFilter();
                yield "list-results";
            }
            case "e", "E", "4" -> {
                exMan.filterExamResultsOutput("Essay");
                yield "list-results";
            }
            case "m", "M", "5" -> {
                exMan.filterExamResultsOutput("Multiple choice");
                yield "list-results";
            }
            default -> "main";
        };
    }
}
