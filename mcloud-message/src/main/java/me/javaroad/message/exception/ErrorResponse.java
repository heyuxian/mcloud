package me.javaroad.message.exception;

import java.util.Date;

/**
 * @author heyx
 */
public interface ErrorResponse {

    String getCode();

    String getMessage();

    default Date getTimestamp() {
        return new Date();
    }
}
