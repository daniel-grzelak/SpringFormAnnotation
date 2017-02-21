package com.grzelak.annotations;

import com.grzelak.classes.Producer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class ProducerListValidation implements ConstraintValidator<ProducerList, List<Producer>> {

    @Override
    public void initialize(ProducerList producerList) {

    }

    @Override
    public boolean isValid(List<Producer> producers, ConstraintValidatorContext constraintValidatorContext) {
        if(producers.size() > 1) {
            return false;
        } else {
            return true;
        }
    }
}
