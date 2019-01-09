package me.javaroad.mcloud.apigw.rest;

import lombok.RequiredArgsConstructor;
import me.javaroad.mcloud.apigw.config.GatewaySwaggerResourcesProvider.KeycloakProperties;
import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.web.request.LoginRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
@RequiredArgsConstructor
public class AuthManager {

    private final KeycloakProperties keycloakProperties;
    private final AuthClient authClient;

    public AuthDto login(LoginRequest loginRequest) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", keycloakProperties.getClient().getClientId());
        params.add("client_secret", keycloakProperties.getClient().getClientSecret());
        params.add("username", loginRequest.getUsername());
        params.add("password", loginRequest.getPassword());
        return authClient.login(params);
    }
}
