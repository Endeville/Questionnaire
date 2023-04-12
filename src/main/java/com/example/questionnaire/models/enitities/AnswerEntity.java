package com.example.questionnaire.models.enitities;

import com.example.questionnaire.models.enitities.enums.QuestionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")
public class AnswerEntity extends BaseEntity{

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean correct;

    @ManyToOne
    private QuestionEntity question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return answer;
    }
}
