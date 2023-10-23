package system.student;

import system.exam.Scorable;
import java.util.ArrayList;

public class Student implements Printable {
    int studentId;
    String studentName;
    ArrayList<Scorable> examsTaken;

    @Override
    public String printSummaryResult() {
        return null;
    }

    @Override
    public String printDetailedResults() {
        return null;
    }
}
