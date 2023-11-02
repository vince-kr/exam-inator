package examinator.manager.interact.reqresdef;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;

public class ListStudents implements Interaction {
    String header = "LIST OF ALL STUDENTS";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        System.out.println(exMan.getAllStudents());

        return "main";
    }
}
