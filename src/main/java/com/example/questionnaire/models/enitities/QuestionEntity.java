package com.example.questionnaire.models.enitities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "questions")
public class QuestionEntity extends BaseEntity {

    private String description;

    @ManyToOne
    private QuestionTypeEntity questionType;

    @OneToMany(mappedBy = "question")
    private Set<AnswerEntity> answers;

    public String getDescription() {
        return description;
    }

    public QuestionEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public QuestionTypeEntity getQuestionType() {
        return questionType;
    }

    public QuestionEntity setQuestionType(QuestionTypeEntity questionType) {
        this.questionType = questionType;
        return this;
    }

    public Set<AnswerEntity> getAnswers() {
        return answers;
    }

    public QuestionEntity setAnswers(Set<AnswerEntity> answers) {
        this.answers = answers;
        return this;
    }
}
