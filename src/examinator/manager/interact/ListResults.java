package examinator.manager.interact;

import examinator.ExamResult;
import examinator.manager.ExamManagement;

import java.util.ArrayList;
import java.util.Collections;

public class ListResults implements Interaction {
    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        String header = "LIST ALL RESULTS";

        for (ExamResult result : exMan.getExamResults()) {
            System.out.println(result);
        }

        return "sort-options";
    }
}