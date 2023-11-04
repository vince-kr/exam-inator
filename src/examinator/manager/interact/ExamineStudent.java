package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.student.Student;
import util.io.Files;
import util.io.UserInput;

import java.util.ArrayList;

public class ExamineStudent implements Interaction {
    String header = "DETAILS OF ONE STUDENT";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        ArrayList<Student> allStudents = exMan.getAllStudents();

        if (allStudents.isEmpty()) {
            System.out.println("No students are registered yet!\n" +
                    "Please use the appropriate menu option to add a new student.");
            return "main";
        }

        System.out.println(header);

        for (int i = 0; i < allStudents.size(); i++) {
            Student current = allStudents.get(i);
            System.out.println(i + 1 + ".\t" + current.getStudentName());
        }
        System.out.println();

        Student targetStudent = selectStudent(allStudents);
        String detailedResults = targetStudent.printDetailedResults();
        System.out.println(detailedResults);

        String prompt = "Would you like to write the student's details to file? [y/n] ";
        String responsePattern = "^[YyNn]$";
        String wantsToPrint = UserInput.getValidString(prompt, responsePattern);

        if (wantsToPrint.equals("y") || wantsToPrint.equals("Y"))
            Files.writeStudentDetails(targetStudent.getStudentName(), detailedResults);

        return "main";
    }

    private Student selectStudent(ArrayList<Student> allStudents) {
        String prompt = "Please enter the number corresponding to your student: ";

        int choice = UserInput.getValidPositiveInteger(prompt, allStudents.size());
        return allStudents.get(choice - 1);
    }
}
