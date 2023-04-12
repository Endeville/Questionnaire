package com.example.questionnaire.models.views;

public class ProfileViewDto {
    private String username;
    private String email;
    private Long attempts;
    private Long rightAnswers;

    public String getUsername() {
        return username;
    }

    public ProfileViewDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ProfileViewDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getAttempts() {
        return attempts;
    }

    public ProfileViewDto setAttempts(Long attempts) {
        this.attempts = attempts;
        return this;
    }

    public Long getRightAnswers() {
        return rightAnswers;
    }

    public ProfileViewDto setRightAnswers(Long rightAnswers) {
        this.rightAnswers = rightAnswers;
        return this;
    }
}
