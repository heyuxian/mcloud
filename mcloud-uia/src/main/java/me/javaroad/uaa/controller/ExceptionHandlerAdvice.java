package me.javaroad.uaa.controller;

import me.javaroad.common.exception.InvalidParameterException;
import me.javaroad.common.exception.UnauthorizedException;
import me.javaroad.uaa.controller.response.ErrorResponse;
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

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse unauthorized(UnauthorizedException e) {
        return ErrorResponse.builder().errorCode(401).message("unauthorized").build();
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidParameter(InvalidParameterException e) {
        return ErrorResponse.builder().errorCode(402).message(e.getMessage()).build();
    }
}
