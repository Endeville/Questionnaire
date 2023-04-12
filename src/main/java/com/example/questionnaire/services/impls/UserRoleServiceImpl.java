package com.example.questionnaire.services.impls;

import com.example.questionnaire.models.enitities.UserRoleEntity;
import com.example.questionnaire.models.enitities.enums.UserRole;
import com.example.questionnaire.repositories.UserRoleRepository;
import com.example.questionnaire.services.interfaces.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleEntity findByRole(UserRole role) {
        return userRoleRepository.findUserRoleEntityByRole(role)
                .orElseThrow(IllegalStateException::new);
    }
}
