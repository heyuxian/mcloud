package me.javaroad.mcloud.apigw.web.controller;

import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.rest.AuthApi;
import me.javaroad.mcloud.apigw.web.request.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthApi authApi;

    public AuthController(AuthApi authApi) {
        this.authApi = authApi;
    }

    @PostMapping("login")
    public AuthDto login(@RequestBody LoginRequest loginRequest) {
        return authApi.login(loginRequest);
    }
}
