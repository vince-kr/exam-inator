package examinator.manager.interact.reqresdef;

import java.util.Scanner;

public abstract class Validator {
    public static String getValidInput(String prompt, String responsePattern) {
        return getValidInput(prompt, responsePattern, 0, Integer.MAX_VALUE);
    }

    public static String getValidInput(String prompt, String responsePattern, int min, int max) {
        // Prompt user for input until their input matches the response pattern
        Scanner userIn = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = userIn.nextLine();

        boolean inputIsValid;

        if (userInput.matches(responsePattern) && min <= userInput.length() && userInput.length() <= max)
            return userInput;

        System.out.println("WARNING - " + userInput + " is not valid!");
        return getValidInput(prompt, responsePattern, min, max);
    }
}
