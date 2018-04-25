package me.javaroad.mcloud.apigw.rest;

import me.javaroad.mcloud.apigw.config.KeycloakConfig;
import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.web.request.LoginRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyx
 */
@Component
public class AuthManager {

    private final RestTemplate restTemplate;

    private final KeycloakConfig keycloakConfig;

    public AuthManager(RestTemplateBuilder restTemplateBuilder,
        KeycloakConfig keycloakConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.keycloakConfig = keycloakConfig;
    }

    public AuthDto login(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", keycloakConfig.getClient().getClientId());
        params.add("client_secret", keycloakConfig.getClient().getClientSecret());
        params.add("username", loginRequest.getUsername());
        params.add("password", loginRequest.getPassword());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<AuthDto> responseEntity = restTemplate.exchange(
            keycloakConfig.getClient().getAccessTokenUri(),
            HttpMethod.POST, requestEntity, AuthDto.class);
        return responseEntity.getBody();
    }
}
