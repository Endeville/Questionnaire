package com.example.questionnaire.repositories;

import com.example.questionnaire.models.enitities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    @Query("update UserEntity u " +
            "set u.rightAnswers=u.rightAnswers + :add " +
            "where u.username=:name")
    @Modifying
    @Transactional
    void updateRightAnswers(@Param(value = "name") String name,@Param(value = "add") int i);

    @Query("update UserEntity u " +
            "set u.attempts=u.attempts + :add " +
            "where u.username=:name")
    @Modifying
    @Transactional
    void updateAttempts(@Param(value = "name") String name,@Param(value = "add")  int i);
}
