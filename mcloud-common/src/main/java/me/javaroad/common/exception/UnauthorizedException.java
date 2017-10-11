package me.javaroad.common.exception;

/**
 * @author heyx
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message, Object... params) {
        super(String.format(message, params));
    }
}
