import examinator.manager.ExamManagement;

public class Main {
    public static void main(String[] args) {
        String banner = """
                ===================
                !!  EXAM-INATOR  !!
                ===================
                """;
        System.out.println(banner);

        // Create an ExamManagement instance
        ExamManagement exMan = new ExamManagement();

        // Test functionality by creating various objects
        exMan.runTests();

        // Start the main menu
        while(!exMan.userIsFinished()) {
            exMan.completeInteractionCycle();
        }
    }
}