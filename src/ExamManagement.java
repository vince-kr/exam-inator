import system.exam.Essay;
import system.exam.ExamException;
import system.exam.MultipleChoice;

class ExamManagement {
    Essay testOne;
    MultipleChoice testTwo;

    public ExamManagement() {
        try {
            testOne = new Essay(
                    4,
                    "Software dev",
                    90,
                    "What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? What is it all about, when you get right down to it? ",
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
        System.out.println(testOne.displayExamDetails());
        System.out.println(testTwo.displayExamDetails());
    }
}
