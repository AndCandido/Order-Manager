package com.acsistemas.order_manager.api.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AtLeastOneFieldValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneField {
    String[] fields();

    String message() default "At Least One Field required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
