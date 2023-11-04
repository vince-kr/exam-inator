package examinator.manager.interact;

import examinator.exam.Essay;
import examinator.exam.ExamException;
import examinator.exam.MultipleChoice;
import examinator.exam.Scorable;
import examinator.manager.ExamManagement;
import examinator.student.Student;
import util.io.UserInput;

import java.util.ArrayList;

public class RecordExamResult implements Interaction {
    String header = "RECORD AN EXAM RESULT\n";

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

        try {
            switch (askExamType()) {
                case "e", "E":
                    Scorable newEssay = createNewEssay();
                    targetStudent.addExam(newEssay);
                    exMan.addResult(targetStudent, newEssay);
                    break;
                case "m", "M":
                    Scorable newMultChoice = createNewMultChoice();
                    targetStudent.addExam(newMultChoice);
                    exMan.addResult(targetStudent, newMultChoice);
                    break;
            }
            System.out.println("Exam successfully recorded for student " + targetStudent.getStudentName() + "!");
        } catch (
                ExamException ee) {
            System.out.println(ee.getMessage());
        }

        return "main";
    }

    private Student selectStudent(ArrayList<Student> allStudents) {
        String prompt = "Please enter the number corresponding to your student: ";

        int choice = UserInput.getValidPositiveInteger(prompt, allStudents.size());
        return allStudents.get(choice - 1);
    }

    private String askExamType() {
        String prompt = "Type of exam: [M]ultiple choice or [E]ssay? ";
        String responsePattern = "^[mMeE]$";

        return UserInput.getValidString(prompt, responsePattern);
    }

    private Scorable createNewEssay() throws ExamException {
        int examID = askExamID();
        String subject = askSubject();
        int duration = askDuration();
        String essayAnswer = askAnswer();
        int scoreGrammar = askGrammarScore();
        int scoreContent = askContentScore();
        int wordLimit = askWordLimit();

        return new Essay(examID, subject, duration, essayAnswer, scoreGrammar, scoreContent, wordLimit);
    }

    private Scorable createNewMultChoice() throws ExamException {
        int examID = askExamID();
        String subject = askSubject();
        int duration = askDuration();
        int numQuestions = askNumQuestions();
        int numCorrectAnswers = askNumCorrectAnswers(numQuestions);

        return new MultipleChoice(examID, subject, duration, numCorrectAnswers, numQuestions);
    }

    private int askExamID() {
        String prompt = "Please enter the exam ID. This should consist of only numbers: ";

        return UserInput.getValidPositiveInteger(prompt);
    }

    private String askSubject() {
        String prompt = "Please enter the exam subject. Letters, numbers, spaces, and hyphens are allowed: ";
        String responsePattern = "^[a-zA-Z0-9 -]+$";

        return UserInput.getValidString(prompt, responsePattern);
    }

    private int askDuration() {
        String prompt = "Please enter the exam duration in minutes. This should be between 30 and 180: ";

        return UserInput.getValidPositiveInteger(prompt, 180);
    }

    private String askAnswer() {
        String prompt = "Please enter the essay answer: ";
        String responsePattern = ".+";

        return UserInput.getValidString(prompt, responsePattern);
    }

    private int askGrammarScore() {
        String prompt = "Please enter the student's score on GRAMMAR. This should be between 0 and 100: ";

        return UserInput.getValidPositiveInteger(prompt, 0, 100);
    }

    private int askContentScore() {
        String prompt = "Please enter the student's score on CONTENT. This should be between 0 and 100: ";

        return UserInput.getValidPositiveInteger(prompt, 0, 100);
    }

    private int askWordLimit() {
        String prompt = "Please enter the word limit. This should be a number between 500 and 10,000: ";

        return UserInput.getValidPositiveInteger(prompt, 500, 10000);
    }

    private int askNumQuestions() {
        String prompt = "Please enter the total number of questions on the exam. This should be between 10 and 50: ";

        return UserInput.getValidPositiveInteger(prompt, 10, 50);
    }

    private int askNumCorrectAnswers(int max) {
        String prompt = "Please enter the number of correct answers on the exam. This should be between 0 and the total number of questions: ";

        return UserInput.getValidPositiveInteger(prompt, max);
    }
}