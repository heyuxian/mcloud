package me.javaroad.message.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author heyx
 */
@ControllerAdvice
public class MessageExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MessageException.class)
    public ErrorResponse messageError(MessageException messageException) {
        return messageException.getErrorResponse();
    }
}
