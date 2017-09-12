package me.javaroad.blog.core.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class CurrentUser {
    private Long userId;
    private String username;
}
