package com.example.questionnaire.services.interfaces;

import com.example.questionnaire.models.dtos.UserRegistrationDto;
import com.example.questionnaire.models.views.ProfileViewDto;

public interface UserService {
    boolean emailExists(String email);

    boolean usernameExists(String username);

    void register(UserRegistrationDto user);

    ProfileViewDto getUserProfileByUsername(String name);

    void addRightAnswers(String principal, int i);

    void addAttempts(String username, int i);
}
