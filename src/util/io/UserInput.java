package util.io;

import java.util.Scanner;

public abstract class UserInput {
    public static String getValidUserInput(String prompt, String responsePattern) {
        return getValidUserInput(prompt, responsePattern, 0, Integer.MAX_VALUE);
    }

    public static String getValidUserInput(String prompt, String responsePattern, int min, int max) {
        // Prompt user for input until their input matches the response pattern
        Scanner userIn = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = userIn.nextLine();
        int inputLength = userInput.length();

        if (userInput.matches(responsePattern) && min <= inputLength && inputLength <= max)
            return userInput;

        System.out.println("WARNING - " + userInput + " is not valid!");
        return getValidUserInput(prompt, responsePattern, min, max);
    }
}
