package com.grzelak.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class ScreenValidation implements ConstraintValidator<Screen, Double> {

    private double min;
    private double max;


    @Override
    public void initialize(Screen screen) {
    min = screen.min();
    max = screen.max();

    }

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {

        if(aDouble == null) {
            return false;
        }
        return min <= aDouble && aDouble <= max;
    }
}