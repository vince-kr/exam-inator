public class Main {
    public static void main(String[] args) {
        ExamManagement examManager = new ExamManagement();

        UserInteractor ui = new UserInteractor();
        while (!ui.isFinished()) {
            ui.printNextMenu();
        }
    }
}