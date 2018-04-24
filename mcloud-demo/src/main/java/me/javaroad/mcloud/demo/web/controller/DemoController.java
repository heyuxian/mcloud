package me.javaroad.mcloud.demo.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping("info")
public class DemoController {

    @GetMapping
    @ApiOperation("Just a sample api")
    public String current() {
        String current = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "hello: " + current;
    }
}
