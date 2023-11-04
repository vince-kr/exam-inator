package examinator.manager.interact;

import examinator.manager.ExamManagement;
import examinator.student.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static util.io.UserInput.getValidStringInput;

public class PrintStudentList implements Interaction {
    String header = "PRINT STUDENT LIST";
    Menu menu = new Menu();
    String prompt = "Would you like to print the students list? [y/n] ";
    String responsePattern = "^[YyNn]$";

    @Override
    public String transmitAndReceive(ExamManagement exMan) {
        System.out.println(header);
        String userInput = getValidStringInput(prompt, responsePattern);

        if (userInput.equals("y") || userInput.equals("Y")) {
            StringBuilder allStudents = new StringBuilder();
            for (Student student : exMan.getAllStudents()) {
                allStudents.append(student);
                allStudents.append("\n");
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("students_list.txt"));
                writer.write(allStudents.toString());
                writer.close();
                System.out.println("SUCCESS - students saved in 'students_list.txt'");
            } catch (IOException ie) {
                System.out.println("ERROR - not able to write the students file.");
                System.out.println(ie.getMessage());
            }

        }

        return "main";
    }
}
