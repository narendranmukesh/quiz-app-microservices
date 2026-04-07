package com.microservices.quizService.model;

import lombok.Data;

@Data
public class QuizDto {
    String  category;
    Integer numQuestions;
    String title;
}
