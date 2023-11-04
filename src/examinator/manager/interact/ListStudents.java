package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.student.Student;
import util.io.Files;
import util.io.UserInput;

import java.util.ArrayList;

public class ListStudents implements Interaction {

    String header = "LIST OF ALL STUDENTS\n";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        ArrayList<Student> allStudents = exMan.getAllStudents();

        if (allStudents.isEmpty()) {
            System.out.println("No students are registered yet. There's nothing to list.");
            return "main";
        }

        System.out.println(header);

        StringBuilder summaryString = new StringBuilder();
        for (Student student : allStudents) {
            summaryString.append(student);
        }

        System.out.println(summaryString);

        String prompt = "Would you like to save the students list to file? [y/n] ";
        String responsePattern = "^[YyNn]$";
        String wantsToPrint = UserInput.getValidString(prompt, responsePattern);

        if (wantsToPrint.equals("y") || wantsToPrint.equals("Y")) {
            Files.writeStudentList(summaryString.toString());
        }

        return "main";
    }
}
