package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.manager.TestObjectsGenerator;
import util.io.UserInput;

public class LoadSamples implements Interaction {
    String header = "LOAD SAMPLE DATA";
    String prompt = "This will load 6 students and 15 exams. Continue? [y/n] ";
    String responsePattern = "^[YyNn]$";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);

        String userInput = UserInput.getValidString(prompt, responsePattern);

        if (userInput.equals("y") || userInput.equals("Y")) {
            TestObjectsGenerator.loadSampleData(exMan);
            System.out.println("Sample data loaded successfully!");
        }

        return "main";
    }
}
