package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;
import examinator.student.Student;

import java.util.ArrayList;

public class ListStudents implements Interaction {
    String header = "LIST OF ALL STUDENTS";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);

        ArrayList<Student> allStudents = exMan.getAllStudents();

        for (Student student : allStudents) {
            System.out.println(student);
        }

        return "main";
    }
}
