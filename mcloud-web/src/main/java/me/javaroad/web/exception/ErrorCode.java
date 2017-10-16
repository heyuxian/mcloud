package me.javaroad.web.exception;

import lombok.Getter;

/**
 * @author heyx
 */
public enum ErrorCode {
    BAD_REQUEST(400),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    SERVER_ERROR(500);
    @Getter
    private Integer code;

    ErrorCode(Integer code) {
        this.code = code;
    }
}
