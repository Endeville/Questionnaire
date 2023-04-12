package com.example.questionnaire.services.impls;

import com.example.questionnaire.models.dtos.UserRegistrationDto;
import com.example.questionnaire.models.enitities.UserEntity;
import com.example.questionnaire.models.enitities.enums.UserRole;
import com.example.questionnaire.models.views.ProfileViewDto;
import com.example.questionnaire.repositories.UserRepository;
import com.example.questionnaire.services.interfaces.UserRoleService;
import com.example.questionnaire.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRoleService userRoleService;
    private final UserDetailsService appUserService;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleService userRoleService, UserDetailsService appUserService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void register(UserRegistrationDto userModel) {
        var user = modelMapper.map(userModel, UserEntity.class);
        user
                .setPassword(passwordEncoder.encode(userModel.getPassword()))
                .setRole(userRoleService.findByRole(UserRole.CLIENT))
                .setAttempts(0L)
                .setRightAnswers(0L);

        userRepository.save(user);

        var userDetails = appUserService.loadUserByUsername(user.getUsername());

        var auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder
                .getContext()
                .setAuthentication(auth);
    }

    @Override
    public ProfileViewDto getUserProfileByUsername(String name) {
        return this.modelMapper.map(this.userRepository.findUserEntityByUsername(name)
                .orElseThrow(IllegalStateException::new),
                ProfileViewDto.class);
    }

    @Override
    public void addRightAnswers(String principal, int i) {
        this.userRepository.updateRightAnswers(principal, i);
    }

    @Override
    public void addAttempts(String username, int i) {
        this.userRepository.updateAttempts(username, i);
    }
}
