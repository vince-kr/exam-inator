import examinator.manager.ExamManagement;

public class Main {
    public static void main(String[] args) {
        String banner = """
                ===================
                !!  EXAM-INATOR  !!
                ===================""";
        System.out.println(banner);

        /*
        ExamManagement class owns collections of Student and ExamResult objects. It also
        manages interaction with the user through CLI.
        */
        ExamManagement exMan = new ExamManagement();

        // Start the main loop
        while(!exMan.userIsFinished()) {
            exMan.completeInteractionCycle();
        }

        System.out.println("Thank you for using EXAM-INATOR!");
    }
}