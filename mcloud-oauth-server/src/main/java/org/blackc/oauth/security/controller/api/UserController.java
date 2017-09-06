package org.blackc.oauth.security.controller.api;

import static org.blackc.oauth.security.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.blackc.oauth.security.dto.UserDto;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.service.OAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/users")
public class UserController {

    private final OAuthUserService userService;
    private final OAuthMapper mapper;

    @Autowired
    public UserController(OAuthUserService userService, OAuthMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "创建user", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        return null;
    }

    @ApiOperation(value = "修改user", httpMethod = "PUT")
    @PutMapping("{userId}")
    public UserDto modifyUser(@PathVariable Long userId, @RequestBody @Valid UserDto userDto) {
        return null;
    }

    @ApiOperation(value = "获取user", httpMethod = "GET")
    @GetMapping("{userId}")
    public UserDto modifyUser(@PathVariable Long userId) {
        return null;
    }

    @ApiOperation(value = "删除user", httpMethod = "DELETE")
    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
    }
}
