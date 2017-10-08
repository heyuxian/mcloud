package me.javaroad.common.exception;

/**
 * @author heyx
 */
public class DataConflictException extends RuntimeException {

    public DataConflictException(String message, Object... params) {
        super(String.format(message, params));
    }

}
