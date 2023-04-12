package com.example.questionnaire.models.enitities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Long attempts;

    @Column(nullable = false)
    private Long rightAnswers;

    @ManyToOne(optional=false, cascade = CascadeType.DETACH)
    private UserRoleEntity role;

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public UserEntity setRole(UserRoleEntity role) {
        this.role = role;
        return this;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getAttempts() {
        return attempts;
    }

    public UserEntity setAttempts(Long attempts) {
        this.attempts = attempts;
        return this;
    }

    public Long getRightAnswers() {
        return rightAnswers;
    }

    public UserEntity setRightAnswers(Long rightAnswers) {
        this.rightAnswers = rightAnswers;
        return this;
    }
}
