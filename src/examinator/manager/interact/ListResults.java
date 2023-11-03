package examinator.manager.interact;

import examinator.ExamResult;
import examinator.manager.ExamManagement;

import java.util.ArrayList;
import java.util.Collections;

public class ListResults implements Interaction {
    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        String header = "LIST ALL RESULTS";
        ArrayList<ExamResult> allResults = exMan.getExamResults();

        Collections.sort(allResults);

        for (ExamResult result : allResults) {
            System.out.println(result);
        }

        return "main";
    }
}
