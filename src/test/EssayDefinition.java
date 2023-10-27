package test;

public record EssayDefinition(
        int examId,
        String subject,
        int duration,
        String essayAnswer,
        int grammar,
        int content,
        int wordLimit){}