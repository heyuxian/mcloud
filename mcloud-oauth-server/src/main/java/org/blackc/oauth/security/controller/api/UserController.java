package org.blackc.oauth.security.controller.api;

import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import org.blackc.oauth.security.dto.UserDto;
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
    public UserDto getUser(Principal principal) {
        return UserDto.builder().id(1L).username("123").build();
    }

}
