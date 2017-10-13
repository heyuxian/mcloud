package me.javaroad.blog.controller.api;

import java.security.Principal;
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
    public Principal me(Principal principal) {
        return principal;
    }
}
