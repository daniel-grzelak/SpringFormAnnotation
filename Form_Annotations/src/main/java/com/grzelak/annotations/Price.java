package com.grzelak.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
@Documented
@Constraint(validatedBy = PriceValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {
    String message() default "Price validation error";
    double min() default 1000;
    double max() default 3500;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
