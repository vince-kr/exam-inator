package util.io;

import java.util.Scanner;

public abstract class UserInput {

    public static String getValidString(
            String prompt, String responsePattern, int min, int max) {
        // Prompt user for input until their input matches the response pattern and length
        Scanner userIn = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = userIn.nextLine();
        int inputLength = userInput.length();

        // User's input matches the response pattern and length: return it
        if (userInput.matches(responsePattern) && min <= inputLength && inputLength <= max)
            return userInput;

        // Input does not match: warn the user, then recursively call the method
        System.out.println("WARNING - your input '" + userInput + "' is not valid!");
        return getValidString(prompt, responsePattern, min, max);
    }

    public static String getValidString(String prompt, String responsePattern) {
        // Like above, but we don't care about the length of the input
        return getValidString(prompt, responsePattern, 0, Integer.MAX_VALUE);
    }

    public static int getValidPositiveInteger(String prompt, int min, int max) {
        // Prompt user for a positive number from min to max inclusive
        Scanner userIn = new Scanner(System.in);

        System.out.print(prompt);
        String userInput = userIn.nextLine();

        int numberEntered;
        boolean numberCanBeFormatted;

        if (userInput.matches("^[0-9]+$")) {  // regex match: at least one number
            try {
                numberEntered = Integer.parseInt(userInput);
                numberCanBeFormatted = true;
            } catch (NumberFormatException nf) {
                numberEntered = 0;
                numberCanBeFormatted = false;
            }
            if (numberCanBeFormatted && min <= numberEntered && numberEntered <= max) {
                return numberEntered;
            }
        }

        System.out.println("WARNING - your input '" + userInput + "' is not valid!");
        return getValidPositiveInteger(prompt, max);
    }

    public static int getValidPositiveInteger(String prompt, int max) {
        // Like above, but lower bound is 1
        return getValidPositiveInteger(prompt, 1, max);
    }

    public static int getValidPositiveInteger(String prompt) {
        // Like above, but no limits as long as it fits in memory
        return getValidPositiveInteger(prompt, 0, Integer.MAX_VALUE);
    }
}
