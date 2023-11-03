package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.student.Student;
import static util.io.UserInput.*;

import java.util.ArrayList;

public class ExamineStudent implements Interaction {
    String header = "DETAILS OF ONE STUDENT";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        ArrayList<Student> allStudents = exMan.getAllStudents();

        if (allStudents.size() < 1) {
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

        String detailedResults = selectStudent(allStudents).printDetailedResults();
        System.out.println(detailedResults);

        return "main";
    }

    private Student selectStudent(ArrayList<Student> allStudents) {
        String prompt = "Please enter the number corresponding to your student: ";

        int choice = getValidInteger(prompt, 1, allStudents.size());
        return allStudents.get(choice - 1);
    }
}
