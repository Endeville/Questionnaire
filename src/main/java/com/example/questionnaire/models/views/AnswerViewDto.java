package com.example.questionnaire.models.views;

public class AnswerViewDto {
    private String answer;
    private Long id;

    public String getAnswer() {
        return answer;
    }

    public AnswerViewDto setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AnswerViewDto setId(Long id) {
        this.id = id;
        return this;
    }
}
