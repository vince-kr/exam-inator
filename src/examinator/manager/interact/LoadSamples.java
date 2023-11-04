package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.manager.TestObjectGenerator;

import static util.io.UserInput.getValidStringInput;

public class LoadSamples implements Interaction {
    String header = "LOAD SAMPLE DATA";
    String prompt = "This will load 6 students and 15 exams. Continue? [y/n] ";
    String responsePattern = "^[YyNn]$";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);

        String userInput = getValidStringInput(prompt, responsePattern);

        if (userInput.equals("y") || userInput.equals("Y")) {
            TestObjectGenerator.loadSampleData(exMan);
            System.out.println("Sample data loaded successfully!");
        }

        return "main";
    }
}
