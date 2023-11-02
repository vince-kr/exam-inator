package examinator.manager.interact.reqresdef;

import examinator.manager.ExamManagement;
import examinator.manager.interact.Interaction;
import examinator.student.Student;
import examinator.student.StudentException;
import util.io.UserInput;

import static util.io.UserInput.getValidUserInput;

public class AddStudent implements Interaction {

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        String studentID = askStudentID();
        String studentName = askStudentName();

        try {
            Student newStudent = new Student(Integer.parseInt(studentID), studentName);
            exMan.addStudent(newStudent);
            System.out.println("Student " + newStudent.getStudentName() + " added successfully!");
        } catch (StudentException se) {
            se.getMessage();
        }

        return "main";
    }

    private String askStudentID() {
        String prompt = "Please enter the student's ID; this should consist of only numbers: ";
        String responsePattern = "^[0-9]+$";

        return UserInput.getValidUserInput(prompt, responsePattern);
    }

    private String askStudentName() {
        String prompt = "Please enter the student's name\n" +
                "The name should be between 2 and 30 characters and may contain upper- and lowercase letters, spaces, and hyphens: ";
        String responsePattern = "^[a-zA-Z -]+$";

        return getValidUserInput(prompt, responsePattern, 2, 30);
    }
}
