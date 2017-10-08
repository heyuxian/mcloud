package me.javaroad.oauth.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author heyx
 */
@Controller
public class IndexController {

    @GetMapping({"index", "/"})
    public String index() {
        return "starter";
    }
}
