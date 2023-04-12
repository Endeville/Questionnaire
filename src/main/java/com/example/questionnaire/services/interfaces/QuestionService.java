package com.example.questionnaire.services.interfaces;

import com.example.questionnaire.models.views.QuestionViewDto;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    Long getQuestionCount();

    QuestionViewDto findQuestionById(Long questionId);

    void checkAnswers(String username, Long questionId, Set<Long> answers);
}
