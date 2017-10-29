package ru.urlshortening.abbreviator.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = URLAbbreviationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CheckURLAbbreviation {
    String message() default "URLAbbreviation is wrong!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
