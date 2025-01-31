package com.acsistemas.order_manager.api.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class AtLeastOneFieldValidator implements ConstraintValidator<AtLeastOneField, Object> {
    String[] fields;

    @Override
    public void initialize(AtLeastOneField constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = value.getClass().getDeclaredField(fields[i]);
                field.setAccessible(true);
                Object fieldValue = field.get(value);
                if(fieldValue != null) return true;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return false;
            }
        }
        return false;
    }
}
