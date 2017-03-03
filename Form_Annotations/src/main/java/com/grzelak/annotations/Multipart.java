package com.grzelak.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
@Documented
@Constraint(validatedBy = MultipartValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Multipart {

    String message() default "Filename validation error";
    String regex() default "([A-Z]){0,10}_([A-Z]|[0-9]|\\s){0,10}_[0-9]{0,4}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
