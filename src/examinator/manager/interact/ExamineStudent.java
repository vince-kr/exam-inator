package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.student.Student;
import static util.io.UserInput.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExamineStudent implements Interaction {
    String header = "DETAILS OF ONE STUDENT";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        ArrayList<Student> allStudents = exMan.getAllStudents();

        if (allStudents.isEmpty()) {
            System.out.println("No students are registered yet!\n" +
                    "Please use the appropriate options to add a new student or record an exam result.");
            return "main";
        }

        System.out.println(header);

        for (int i = 0; i < allStudents.size(); i++) {
            Student current = allStudents.get(i);
            System.out.println(i + 1 + ".\t" + current.getStudentName());
        }
        System.out.println();

        Student student = selectStudent(allStudents);
        String detailedResults = student.printDetailedResults();
        System.out.println(detailedResults);

        String prompt = "Would you like to print the student's details? [y/n] ";
        String responsePattern = "^[YyNn]$";
        String wantsToPrint = getValidStringInput(prompt, responsePattern);

        if (wantsToPrint.equals("y") || wantsToPrint.equals("Y"))
            writeDetails(student.getStudentName(), detailedResults);

        return "main";
    }

    private Student selectStudent(ArrayList<Student> allStudents) {
        String prompt = "Please enter the number corresponding to your student: ";

        int choice = getValidPositiveInteger(prompt, allStudents.size());
        return allStudents.get(choice - 1);
    }

    private void writeDetails(String name, String details) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"));
            writer.write(details);
            writer.close();
            System.out.println("SUCCESS - students saved in 'students_list.txt'");
        } catch (
                IOException ie) {
            System.out.println("ERROR - not able to write the students file.");
            System.out.println(ie.getMessage());
        }
    }
}
