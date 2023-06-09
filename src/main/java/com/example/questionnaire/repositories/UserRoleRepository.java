package com.example.questionnaire.repositories;

import com.example.questionnaire.models.enitities.UserRoleEntity;
import com.example.questionnaire.models.enitities.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findUserRoleEntityByRole(UserRole role);
}
