package me.javaroad.oauth.security.controller.api;

import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author heyx
 */
@Controller
public class UserController {


    @ApiOperation(value = "获取user", httpMethod = "GET")
    @GetMapping("me")
    @ResponseBody
    public Principal getUser(Principal principal) {
        return principal;
    }

}
