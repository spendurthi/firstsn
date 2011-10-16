package com.standone.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.standone.hbr.vo.User;

public class UserValidation implements Validator {

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "userId", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "password.required");
		User user = (User) arg0;
	}
	@Override
	public boolean supports(Class arg0) {
		return User.class.isAssignableFrom(arg0);
	}

}
