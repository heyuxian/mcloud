package me.javaroad.mcloud.apigw.rest;

import me.javaroad.mcloud.apigw.config.GatewaySwaggerResourcesProvider.KeycloakProperties;
import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.web.request.LoginRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyx
 */
@Component
public class AuthManager {

    private final KeycloakProperties keycloakProperties;

    private final AuthClient authClient;

    public AuthManager(KeycloakProperties keycloakProperties, AuthClient authClient) {
        this.keycloakProperties = keycloakProperties;
        this.authClient = authClient;
    }

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
