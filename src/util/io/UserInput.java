package util.io;

import java.util.Scanner;

public abstract class UserInput {
    public static String getValidStringInput(String prompt, String responsePattern) {
        return getValidStringInput(prompt, responsePattern, 0, Integer.MAX_VALUE);
    }

    public static String getValidStringInput(String prompt, String responsePattern, int min, int max) {
        // Prompt user for input until their input matches the response pattern
        Scanner userIn = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = userIn.nextLine();
        int inputLength = userInput.length();

        if (userInput.matches(responsePattern) && min <= inputLength && inputLength <= max)
            return userInput;

        System.out.println("WARNING - your input '" + userInput + "' is not valid!");
        return getValidStringInput(prompt, responsePattern, min, max);
    }

    public static int getValidInteger(String prompt) {
        return getValidInteger(prompt, 0, Integer.MAX_VALUE);
    }

    public static int getValidInteger(String prompt, int min, int max) {
        Scanner userIn = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = userIn.nextLine();

        int numberEntered;

        if (userInput.matches("^[0-9]+$")) {
            numberEntered = Integer.parseInt(userInput);
            if (min <= numberEntered && numberEntered <= max) {
                return numberEntered;
            }
        }

        System.out.println("WARNING - your input '" + userInput + "' is not valid!");
        return getValidInteger(prompt, min, max);
    }
}
