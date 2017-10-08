package me.javaroad.common.exception;

/**
 * @author heyx
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message, Object... params) {
        super(String.format(message, params));
    }
}
