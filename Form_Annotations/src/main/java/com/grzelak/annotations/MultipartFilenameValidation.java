package com.grzelak.annotations;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class MultipartFilenameValidation implements ConstraintValidator<MultipartFilename, String> {
    private String regex;
    @Override
    public void initialize(MultipartFilename multipartFilename) {
        regex = multipartFilename.regex();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches(regex) ;
    }
}
