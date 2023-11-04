package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.student.Student;
import examinator.student.StudentException;
import util.io.UserInput;

public class AddStudent implements Interaction {

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        int studentID = askStudentID();
        String studentName = askStudentName();

        try {
            Student newStudent = new Student(studentID, studentName);
            exMan.addStudent(newStudent);
            System.out.println("Student " + newStudent.getStudentName() + " added successfully!");
        } catch (StudentException se) {  // Should never occur thanks to input validation
            se.getMessage();
        }

        return "main";
    }

    private int askStudentID() {
        String prompt = "Please enter the student's ID; this should consist of only numbers: ";

        return UserInput.getValidPositiveInteger(prompt);
    }

    private String askStudentName() {
        String prompt = "Please enter the student's name\n" +
                "The name should be between 2 and 30 characters and may contain upper- and lowercase ASCII letters, spaces, and hyphens: ";
        String responsePattern = "^[a-zA-Z -]+$";

        return UserInput.getValidString(prompt, responsePattern, 2, 30);
    }
}
