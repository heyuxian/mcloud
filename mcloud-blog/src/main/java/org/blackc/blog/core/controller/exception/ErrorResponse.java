package org.blackc.blog.core.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Integer code;
    private String message;
}
