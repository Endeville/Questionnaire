package com.example.questionnaire.models.dtos.rest;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class AnswerCheckDto {
    private Set<String> answer;

    public Set<String> getAnswer() {
        return answer;
    }

    public AnswerCheckDto setAnswer(Set<String> answer) {
        this.answer = answer;
        return this;
    }
}
