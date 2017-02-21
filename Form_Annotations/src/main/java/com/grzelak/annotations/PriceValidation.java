package com.grzelak.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class PriceValidation implements ConstraintValidator<Price, Double> {
   private double min;
   private double max;

   public void initialize(Price price) {
   min = price.min();
   max = price.max();
   }

   public boolean isValid(Double obj, ConstraintValidatorContext context) {
      return min <= obj && obj <= max;
   }

}
