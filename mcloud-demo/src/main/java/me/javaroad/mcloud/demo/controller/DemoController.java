package me.javaroad.mcloud.demo.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class DemoController {

    @GetMapping("me")
    public Principal current(Principal principal) {
        return principal;
    }
}
