import system.exam.Essay;
import system.exam.ExamException;
import system.exam.MultipleChoice;
import system.student.Student;
import system.student.StudentException;

class ExamManagement {
    Essay testOne;
    MultipleChoice testTwo;
    Student testStudent;

    public ExamManagement() {
        try {
            testOne = new Essay(
                    4,
                    "Software dev",
                    90,
                    "What is it all about, when you get right down to it?",
                    96,
                    94,
                    500
            );
        } catch (ExamException ee) {
            System.out.println("ERROR - " + ee.getMessage());
        }

        try {
            testTwo = new MultipleChoice(
                    5,
                    "Bird quiz",
                    60,
                    12,
                    15
            );
        } catch (ExamException ee) {
            System.out.println("ERROR - " + ee.getMessage());
        }

        try {
            testStudent = new Student(42, "Vince");
        } catch (StudentException se) {
            System.out.println("ERROR - " + se.getMessage());
        }

        System.out.println(testOne.displayExamDetails());
        System.out.println(testTwo.displayExamDetails());

        System.out.println(testStudent.printSummaryResult());
    }
}
