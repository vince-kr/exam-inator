import system.exam.Essay;
import system.exam.ExamException;

class ExamManagement {
    Essay testOne;
    public ExamManagement() {
        try {
            testOne = new Essay(
                    4,
                    "Software dev",
                    90,
                    "What is it all about, when you get right down to it?",
                    96,
                    94,
                    12
            );
        } catch (ExamException ee) {
            System.out.println("Error: " + ee.getMessage());
        }
        System.out.println(testOne.displayExamDetails());
    }
}
