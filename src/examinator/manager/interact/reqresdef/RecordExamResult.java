package examinator.manager.interact.reqresdef;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;

public class RecordExamResult implements Interaction {
    String header = "RECORD AN EXAM RESULT\n";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);

        return "add-student-1";
    }
}
