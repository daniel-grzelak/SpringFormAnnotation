package com.grzelak.annotations;

import com.grzelak.classes.Producer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class ProducerListValidation implements ConstraintValidator<ProducerList, List<Producer>> {

    private int size;
    @Override
    public void initialize(ProducerList producerList) {
    size = producerList.size();
    }

    @Override
    public boolean isValid(List<Producer> producers, ConstraintValidatorContext constraintValidatorContext) {
        return producers.size() == size;
    }
}
