import examinator.manager.ExamManagement;

public class Main {
    public static void main(String[] args) {
        String banner = """
                ===================
                !!  EXAM-INATOR  !!
                ===================""";
        System.out.println(banner);

        ExamManagement exMan = new ExamManagement();

        // Start the main loop
        while(!exMan.userIsFinished()) {
            exMan.completeInteractionCycle();
        }
    }
}