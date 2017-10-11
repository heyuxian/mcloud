package me.javaroad.web.exception;

import lombok.extern.slf4j.Slf4j;
import me.javaroad.common.exception.DataNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author heyx
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ErrorResponse validationError(MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(ErrorCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public ErrorResponse notFound(DataNotFoundException e) {
        log.info(e.getMessage(), e);
        return new ErrorResponse(ErrorCode.NOT_FOUND.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse serverError(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(ErrorCode.SERVER_ERROR.getCode(), e.getMessage());
    }
}
