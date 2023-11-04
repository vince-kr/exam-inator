package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;
import examinator.student.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static util.io.UserInput.getValidStringInput;

public class ListStudents implements Interaction {
    String header = "LIST OF ALL STUDENTS";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);

        ArrayList<Student> allStudents = exMan.getAllStudents();

        for (Student student : allStudents) {
            System.out.println(student);
        }

        String prompt = "Would you like to save the students list to file? [y/n] ";
        String responsePattern = "^[YyNn]$";
        String wantsToPrint = getValidStringInput(prompt, responsePattern);

        if (wantsToPrint.equals("y") || wantsToPrint.equals("Y"))
            createAndWriteSummary(exMan);

        return "main";
    }

    private void createAndWriteSummary(ExamManagement exMan) {
        StringBuilder summaryString = new StringBuilder();
        for (Student student : exMan.getAllStudents()) {
            summaryString.append(student);
            summaryString.append("\n");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students_list.txt"));
            writer.write(summaryString.toString());
            writer.close();
            System.out.println("SUCCESS - students saved in 'students_list.txt'");
        } catch (
                IOException ie) {
            System.out.println("ERROR - not able to write the students file.");
            System.out.println(ie.getMessage());
        }
    }
}
