package com.example.demo.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AboutValidators implements ConstraintValidator<ValidateAbout, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	
		return value.length()<20;
	}
}
