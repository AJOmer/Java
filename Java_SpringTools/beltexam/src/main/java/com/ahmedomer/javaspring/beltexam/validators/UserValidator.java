package com.ahmedomer.javaspring.beltexam.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ahmedomer.javaspring.beltexam.models.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> cla$$) {
        return User.class.equals(cla$$);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;    
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Match");
        }         
    }	
}
