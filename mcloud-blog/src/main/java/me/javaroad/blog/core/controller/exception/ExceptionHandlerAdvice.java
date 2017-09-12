package me.javaroad.blog.core.controller.exception;

import me.javaroad.common.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author heyx
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse dataNotFound(DataNotFoundException e) {
        return new ErrorResponse(ErrorCode.NOT_FOUND.getCode(), e.getMessage());
    }
}
