package com.example.questionnaire.repositories;

import com.example.questionnaire.models.enitities.QuestionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionTypeEntity, Long> {
}
