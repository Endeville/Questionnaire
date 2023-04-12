package com.example.questionnaire.models.validations.enums;

import com.example.questionnaire.services.interfaces.UserService;

public enum FieldType {
    USER_EMAIL(UserService .class, "email"),
    USER_USERNAME(UserService.class, "username");

    private final Class<?> entityHandler;
    private final String fieldName;

    FieldType(Class<?> entityHandler, String name) {
        this.entityHandler = entityHandler;
        this.fieldName = name;
    }

    public Class<?> getEntityHandler() {
        return entityHandler;
    }

    public String getFieldName() {
        return fieldName;
    }
}
