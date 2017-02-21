package com.grzelak.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class ModelValidation implements ConstraintValidator<Model, String> {

    private String regex;
    @Override
    public void initialize(Model model) {
    regex = model.regex();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches(regex);
    }
}
