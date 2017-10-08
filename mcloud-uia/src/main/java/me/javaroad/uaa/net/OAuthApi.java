package me.javaroad.uaa.net;

import me.javaroad.common.exception.UnauthorizedException;
import me.javaroad.uaa.controller.api.request.LoginRequest;
import me.javaroad.uaa.entity.OAuthServerInfo;
import me.javaroad.uaa.entity.TokenInfo;
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
public class OAuthApi {

    private final RestTemplate restTemplate;

    @Autowired
    public OAuthApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TokenInfo token(OAuthServerInfo serverInfo, LoginRequest loginRequest) {
        String accessTokenUrl = serverInfo.buildAccessTokenUrl(loginRequest.getUsername(), loginRequest.getPassword());
        return getTokenInfo(serverInfo, accessTokenUrl);
    }

    public TokenInfo token(OAuthServerInfo serverInfo, String code) {
        String accessTokenUrl = serverInfo.buildAccessTokenUrl(code);
        return getTokenInfo(serverInfo, accessTokenUrl);
    }

    private TokenInfo getTokenInfo(OAuthServerInfo serverInfo, String accessTokenUrl) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", serverInfo.buildBasicAuthString());
        try{
            ResponseEntity<TokenInfo> responseEntity = restTemplate
                .exchange(accessTokenUrl,
                    HttpMethod.POST,
                    new HttpEntity<>(httpHeaders),
                    TokenInfo.class);
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                return responseEntity.getBody();
            }
        } catch (HttpClientErrorException e) {
            throw new UnauthorizedException(e.getResponseBodyAsString());
        }
        throw new UnauthorizedException("unauthorized");
    }
}
