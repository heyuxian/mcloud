package me.javaroad.blog.core.controller.exception;

import lombok.Getter;

/**
 * @author heyx
 */
@Getter
public enum ErrorCode {
    NOT_FOUND(404);
    private Integer code;

    ErrorCode(Integer code) {
        this.code = code;
    }
}
