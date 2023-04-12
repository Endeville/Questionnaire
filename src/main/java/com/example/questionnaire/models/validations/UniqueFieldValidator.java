package com.example.questionnaire.models.validations;

import com.example.questionnaire.models.validations.enums.FieldType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, Object> {
    private final ApplicationContext appContext;

    private FieldType fieldType;
    private String message;

    public UniqueFieldValidator(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Override
    public void initialize(UniqueField constraintAnnotation) {
        this.fieldType = constraintAnnotation.fieldType();
        this.message=constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        var result=false;

        try {
            var instance=appContext.getBean(this.fieldType.getEntityHandler());

            var existsMethod = this.fieldType.getEntityHandler().getDeclaredMethod(String.format("%sExists", this.fieldType.getFieldName()), String.class);
            existsMethod.setAccessible(true);

            result= (boolean) existsMethod.invoke(instance,value);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if(result){
            var className=this.fieldType.getEntityHandler().getSimpleName();
            context
                    .buildConstraintViolationWithTemplate(String.format("%s with such %s already exists", className.substring(0, className.length()-7) ,this.fieldType.getFieldName()))
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return !result;
    }
}
