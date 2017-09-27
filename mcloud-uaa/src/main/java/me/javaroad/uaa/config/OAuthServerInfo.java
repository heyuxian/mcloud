package me.javaroad.uaa.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class OAuthServerInfo {

    private String clientId;
    private String clientSecret;
    private String accessTokenUri;
    private String userAuthorizationUri;

    public String buildAuthorizationUrl(String redirectUrl) {
        return userAuthorizationUri + "?client_id=" + clientId + "&response_type=code&state=" + redirectUrl;
    }

    public String buildAccessTokenUrl(String code) {
        return accessTokenUri + "?grant_type=authorization_code&client_id=" + clientId
            + "&code=" + code;
    }
}
