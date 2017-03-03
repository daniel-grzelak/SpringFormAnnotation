package com.grzelak.annotations;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class MultipartValidation implements ConstraintValidator<Multipart, MultipartFile> {
    private String regex;

    @Override
    public void initialize(Multipart multipart) {
        regex = multipart.regex();
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {

        String multipartFilename = multipartFile.getOriginalFilename();
        if(multipartFilename.contains(".")) {
           multipartFilename = multipartFilename.substring(0, multipartFilename.indexOf('.'));
        }
        System.out.println(multipartFilename);
        return multipartFilename.matches(regex);
    }
}
