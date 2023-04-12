package com.example.questionnaire.models.views;

import java.util.List;

public class QuestionViewDto {
    private String description;
    private String questionType;
    private List<AnswerViewDto> answers;

    public String getDescription() {
        return description;
    }

    public QuestionViewDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getQuestionType() {
        return questionType;
    }

    public QuestionViewDto setQuestionType(String questionType) {
        this.questionType = questionType;
        return this;
    }

    public List<AnswerViewDto> getAnswers() {
        return answers;
    }

    public QuestionViewDto setAnswers(List<AnswerViewDto> answers) {
        this.answers = answers;
        return this;
    }
}
