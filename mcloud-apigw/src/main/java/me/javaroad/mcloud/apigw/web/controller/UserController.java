package me.javaroad.mcloud.apigw.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("me")
    public String userInfo(Authentication authentication) {
        return authentication.getPrincipal().toString();
    }
}
