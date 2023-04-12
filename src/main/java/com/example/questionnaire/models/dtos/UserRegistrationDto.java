package com.example.questionnaire.models.dtos;

import com.example.questionnaire.models.validations.FieldsMatch;
import com.example.questionnaire.models.validations.UniqueField;
import com.example.questionnaire.models.validations.enums.FieldType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@FieldsMatch(
        first = "password",
        second="rePass",
        message = "Passwords should match"
)
public class UserRegistrationDto {

    @NotNull(message = "")
    @Size(min = 4, max=20, message = "The username should be between 4 and 20 characters")
    @UniqueField(fieldType = FieldType.USER_USERNAME)
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email")
    @UniqueField(fieldType = FieldType.USER_EMAIL)
    private String email;

    @NotNull(message = "")
    @Size(min=5, max=30, message = "Password must be between 5 and 30 characters")
    private String password;

    private String rePass;

    public UserRegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRePass() {
        return rePass;
    }

    public UserRegistrationDto setRePass(String rePass) {
        this.rePass = rePass;
        return this;
    }
}
