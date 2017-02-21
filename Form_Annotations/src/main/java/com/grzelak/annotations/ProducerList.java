package com.grzelak.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
@Documented
@Constraint(validatedBy = ProducerListValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProducerList {
    String message() default "ProducerList validation error";
    int size() default  1;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

