package com.example.questionnaire.services.interfaces;

import com.example.questionnaire.models.enitities.UserRoleEntity;
import com.example.questionnaire.models.enitities.enums.UserRole;

public interface UserRoleService {
    UserRoleEntity findByRole(UserRole client);
}
