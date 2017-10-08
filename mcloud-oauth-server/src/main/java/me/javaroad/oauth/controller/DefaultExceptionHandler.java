package me.javaroad.oauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author heyx
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String validationError(BindException e) {
        log.error(e.getMessage(), e);
        return "error/500";
    }

    @ExceptionHandler(Exception.class)
    public String serverError(Exception e) {
        log.error(e.getMessage(), e);
        return "error/500";
    }
}
