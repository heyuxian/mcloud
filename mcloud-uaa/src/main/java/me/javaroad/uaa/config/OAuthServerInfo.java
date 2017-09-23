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

    public String getAuthorizationUri(String redirectUrl) {
        return userAuthorizationUri + "?client_id=" + clientId + "&response_type=code&state=" + redirectUrl;
    }
}
