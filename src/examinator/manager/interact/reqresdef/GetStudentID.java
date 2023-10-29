package examinator.manager.interact.reqresdef;

import examinator.manager.interact.Interaction;

import java.util.Scanner;

public class GetStudentID implements Interaction {
    String prompt = "Please enter the student's ID; this should consist of only numbers: ";

    @Override
    public String transmitAndReceive() {
        String userInput = getValidInput(prompt);

        return "add-student-2";
    }

    private static String getValidInput(String prompt) {
        Scanner userIn = new Scanner(System.in);
        String responsePattern = "^[0-9]+$";

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
