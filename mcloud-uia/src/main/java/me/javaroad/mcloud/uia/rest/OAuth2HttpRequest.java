package me.javaroad.mcloud.uia.rest;

import lombok.RequiredArgsConstructor;
import me.javaroad.common.exception.UnauthorizedException;
import me.javaroad.mcloud.uia.config.OAuth2Property;
import me.javaroad.mcloud.uia.entity.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyx
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OAuth2HttpRequest {

    private final RestTemplate restTemplate;
    private final OAuth2Property oauth2Property;

    public AccessToken token(String username, String password) {
        String accessTokenUrl = oauth2Property.buildAccessTokenUrl(username, password);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", oauth2Property.buildBasicAuthString());
        try {
            ResponseEntity<AccessToken> responseEntity = restTemplate
                .exchange(accessTokenUrl,
                    HttpMethod.POST,
                    new HttpEntity<>(httpHeaders),
                    AccessToken.class);
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                return responseEntity.getBody();
            }
        } catch (HttpClientErrorException e) {
            throw new UnauthorizedException(e.getResponseBodyAsString());
        }
        throw new UnauthorizedException("unauthorized");
    }
}
