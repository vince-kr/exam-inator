import userinterface.UserInteractor;

public class Main {
    public static void main(String[] args) {
        String banner = """
                ===================
                !!  EXAM-INATOR  !!
                ===================
                """;
        System.out.println(banner);

        System.out.println("Running tests...");
        // Creating an ExamManagement instance exercises the system
        ExamManagement examManager = new ExamManagement();
        System.out.println("Done!");
        System.out.println();

        /*
        // Create a UserInteractor to manage user interaction
        UserInteractor ui = new UserInteractor();
        while (!ui.userIsFinished()) {
            ui.completeInteractionCycle();
        }
         */
    }
}