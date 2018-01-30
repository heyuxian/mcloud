package me.javaroad.mcloud.uia.controller.api;

import io.swagger.annotations.ApiOperation;
import java.util.stream.Collectors;
import javax.validation.Valid;
import me.javaroad.mcloud.uia.dto.request.LoginRequest;
import me.javaroad.mcloud.uia.dto.response.LoginResponse;
import me.javaroad.mcloud.uia.entity.AccessToken;
import me.javaroad.mcloud.uia.rest.OAuth2HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping("api/login")
public class LoginApi {

    @Autowired
    private OAuth2HttpRequest oauth2HttpRequest;
    @Autowired
    private TokenStore tokenStore;

    @ApiOperation(value = "login", httpMethod = "POST")
    @PostMapping
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        AccessToken accessToken = oauth2HttpRequest.token(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = tokenStore.readAuthentication(accessToken.getAccessToken());

        return LoginResponse.builder()
            .accessToken(accessToken.getAccessToken())
            .authority(
                authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .build();
    }
}
