package examinator.manager.interact.reqresdef;

import examinator.manager.interact.Interaction;
import examinator.student.Student;
import examinator.student.StudentException;

import static examinator.manager.interact.reqresdef.Validator.getValidInput;

public class AddStudent implements Interaction {

    @Override
    public String transmitAndReceive() {
        String studentID = getStudentID();
        String studentName = getStudentName();

        Student newStudent;

        try {
            newStudent = new Student(Integer.parseInt(studentID), studentName);
        } catch (StudentException se) {
            se.getMessage();
        }

        return "add-student-2";
    }

    private String getStudentID() {
        String prompt = "Please enter the student's ID; this should consist of only numbers: ";
        String responsePattern = "^[0-9]+$";

        return getValidInput(prompt, responsePattern);
    }

    private String getStudentName() {
        String prompt = "Please enter the student's name\n" +
                "The name should be between 2 and 30 characters and may contain upper- and lowercase letters, spaces, and hyphens: ";
        String responsePattern = "^[a-zA-Z -]+$";

        return getValidInput(prompt, responsePattern, 2, 30);
    }
}
