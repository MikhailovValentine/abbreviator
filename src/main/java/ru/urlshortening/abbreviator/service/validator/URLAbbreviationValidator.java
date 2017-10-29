package ru.urlshortening.abbreviator.service.validator;


import ru.urlshortening.abbreviator.models.URLAbbreviation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class URLAbbreviationValidator implements ConstraintValidator<CheckURLAbbreviation, URLAbbreviation> {

    private static final String URL_VALIDATION_REGEX = "^https?://[-A-Za-z0-9&@#/%?=~_|!:,.;+()\\u00A0-\\uD7FF\\uE000-\\uFDCF\\uFDF0-\\uFFFD" +
            "\\u10000-\\u1FFFD\\u20000-\\u2FFFD\\u30000-\\u3FFFD\\u40000-\\u4FFFD\\u50000-\\u5FFFD\\u60000-\\u6FFFD\\u70000-\\u7FFFD\\u80000-\\u8FFFD" +
            "\\u90000-\\u9FFFD\\uA0000-\\uAFFFD\\uB0000-\\uBFFFD\\uC0000-\\uCFFFD\\uD0000-\\uDFFFD\\uE1000-\\uEFFFD\\uF0000-\\uFFFFD\\u100000-\\u10FFFD]+" +
            "[-A-Za-z0-9&@#/%?=~_|!:,.;+()\\u00A0-\\uD7FF\\uE000-\\uFDCF\\uFDF0-\\uFFFD\\u10000-\\u1FFFD\\u20000-\\u2FFFD\\u30000-\\u3FFFD\\u40000-\\u4FFFD" +
            "\\u50000-\\u5FFFD\\u60000-\\u6FFFD\\u70000-\\u7FFFD\\u80000-\\u8FFFD\\u90000-\\u9FFFD\\uA0000-\\uAFFFD\\uB0000-\\uBFFFD\\uC0000-\\uCFFFD" +
            "\\uD0000-\\uDFFFD\\uE1000-\\uEFFFD\\uF0000-\\uFFFFD\\u100000-\\u10FFFD]$";

    @Override
    public void initialize(CheckURLAbbreviation constraintAnnotation) {
    }

    @Override
    public boolean isValid(URLAbbreviation value, ConstraintValidatorContext context) {
        String realURL = value.getRealURL();
        boolean result = true;
        if (realURL == null || realURL.isEmpty() || !realURL.matches(URL_VALIDATION_REGEX)) {
            result &= false;
        }
        return result;
    }
}
