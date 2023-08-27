package com.example.demo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = AboutValidators.class)

public @interface ValidateAbout {
	
	String message() default "About cannot be more than 20 characters";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
