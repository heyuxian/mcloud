package me.javaroad.message.exception;

import lombok.Getter;

/**
 * @author heyx
 */
public class MessageException extends RuntimeException {

    @Getter
    private ErrorResponse errorResponse;

    public MessageException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
