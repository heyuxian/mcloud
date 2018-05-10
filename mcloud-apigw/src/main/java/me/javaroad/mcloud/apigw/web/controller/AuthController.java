package me.javaroad.mcloud.apigw.web.controller;

import java.util.Collections;
import java.util.List;
import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.mapper.AuthMapper;
import me.javaroad.mcloud.apigw.rest.AuthManager;
import me.javaroad.mcloud.apigw.web.request.LoginRequest;
import me.javaroad.mcloud.apigw.web.response.AuthResponse;
import org.springframework.security.oauth2.provider.token.TokenStore;
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

    private final AuthManager authManager;
    private final AuthMapper authMapper;
    private final TokenStore tokenStore;

    public AuthController(AuthManager authManager, AuthMapper authMapper,
        TokenStore tokenStore) {
        this.authManager = authManager;
        this.authMapper = authMapper;
        this.tokenStore = tokenStore;
    }

    @PostMapping("login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        AuthDto authDto = authManager.login(loginRequest);
        AuthResponse authResponse = authMapper.toResponse(authDto);
        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) tokenStore
            .readAccessToken(authDto.getAccessToken())
            .getAdditionalInformation().getOrDefault("roles", Collections.emptyList());
        authResponse.setRoles(roles);
        return authResponse;
    }
}
