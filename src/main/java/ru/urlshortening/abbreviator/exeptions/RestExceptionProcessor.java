package ru.urlshortening.abbreviator.exeptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = "ru.urlshortening.abbreviator")
public class RestExceptionProcessor {
//    @ExceptionHandler
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public JsonError exception(Exception ex) {
//        return new JsonError(ex.getMessage());
//    }
}
