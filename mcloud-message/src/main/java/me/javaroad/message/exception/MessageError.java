package me.javaroad.message.exception;

/**
 * @author heyx
 */
public enum MessageError implements ErrorResponse {
    INVALID_USER("invalid user"),
    INVALID_SOURCE("invalid source"),
    INVALID_TYPE("invalid type"),
    INVALID_CODE("invalid code");

    private String message;

    MessageError(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}