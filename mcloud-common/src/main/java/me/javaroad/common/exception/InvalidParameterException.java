package me.javaroad.common.exception;

/**
 * @author heyx
 */
public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String message, Object... params) {
        super(String.format(message, params));
    }
}
