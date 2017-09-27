package me.javaroad.oauth.security.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
public class LoginController {

    @PostMapping("login")
    public String login(String username, String password) {
        return "";
    }
}
