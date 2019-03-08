package me.javaroad.mcloud.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class DemoController {

    @GetMapping
    public String current() {
        return "hello world";
    }
}
