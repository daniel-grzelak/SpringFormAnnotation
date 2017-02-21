package com.grzelak.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
@Documented
@Constraint(validatedBy = ScreenValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Screen {
    String message() default "Screen validation error";


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    double min() default 3.5;
    double max() default 6.0;
}
