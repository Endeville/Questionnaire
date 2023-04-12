package com.example.questionnaire.models.enitities;

import com.example.questionnaire.models.enitities.enums.QuestionType;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "question_types")
public class QuestionTypeEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    public QuestionType getQuestionType() {
        return questionType;
    }

    public QuestionTypeEntity setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
        return this;
    }

    @Override
    public String toString() {
        return questionType.name();
    }
}
