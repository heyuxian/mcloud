package me.javaroad.mcloud.apigw.rest;

import me.javaroad.mcloud.apigw.config.GatewaySwaggerResourcesProvider.KeycloakProperties;
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

    private final KeycloakProperties keycloakProperties;

    public AuthManager(RestTemplateBuilder restTemplateBuilder,
        KeycloakProperties keycloakProperties) {
        this.restTemplate = restTemplateBuilder.build();
        this.keycloakProperties = keycloakProperties;
    }

    public AuthDto login(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", keycloakProperties.getClient().getClientId());
        params.add("client_secret", keycloakProperties.getClient().getClientSecret());
        params.add("username", loginRequest.getUsername());
        params.add("password", loginRequest.getPassword());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<AuthDto> responseEntity = restTemplate.exchange(
            keycloakProperties.getClient().getAccessTokenUri(),
            HttpMethod.POST, requestEntity, AuthDto.class);
        return responseEntity.getBody();
    }
}
