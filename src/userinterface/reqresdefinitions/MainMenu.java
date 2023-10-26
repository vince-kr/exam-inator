package userinterface.reqresdefinitions;

import userinterface.Interaction;
import userinterface.Response;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu implements Interaction {
    Menu menuOptions;

    String header = "MAIN MENU\n";
    String prompt = "Please enter the letter or number of your choice: ";

    public MainMenu() {
        menuOptions.add(new MenuItem("Add a student", "a"));
        menuOptions.add(new MenuItem("List all students", "l"));
        menuOptions.add(new MenuItem("Display one student", "d"));
        menuOptions.add(new MenuItem("Store an exam result", "e"));
        menuOptions.add(new MenuItem("Load sample data", "s"));
    }

    @Override
    public Response transmitAndReceive() {
        System.out.println(header);
        System.out.println(menuOptions);

        String userInput = getValidInput(prompt);
        return new Response();
    }

    private static String getValidInput(String prompt) {
        Scanner userIn = new Scanner(System.in);
        String responsePattern = "^[aldes1-5]$";

        System.out.print(prompt);
        String userInput = userIn.nextLine();
        while (!userInput.matches(responsePattern)) {
            System.out.println("WARNING - " + userInput + "is not valid!");
            System.out.println(prompt);
            userInput = userIn.nextLine();
        }
        return userInput;
    }
}
