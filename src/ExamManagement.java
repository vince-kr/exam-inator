import system.Essay;

class ExamManagement {
    public ExamManagement() {
        Essay testOne = new Essay(
                "Software dev",
                90,
                "What is it all about, when you get right down to it?",
                96,
                94,
                12
        );
        System.out.println(testOne.displayExamDetails());
    }
}
