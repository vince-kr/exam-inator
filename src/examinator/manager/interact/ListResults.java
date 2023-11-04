package examinator.manager.interact;

import examinator.ExamResult;
import examinator.manager.ExamManagement;

public class ListResults implements Interaction {
    String header = "LIST ALL RESULTS";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);

        for (ExamResult result : exMan.getExamResults()) {
            System.out.println(result);
        }

        return "sort-options";
    }
}