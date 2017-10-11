package me.javaroad.common.exception;

/**
 * @author heyx
 */
public class DataNotAllowedDeleteException extends RuntimeException {
    public DataNotAllowedDeleteException(String message, Object... params) {
        super(String.format(message, params));
    }
}
