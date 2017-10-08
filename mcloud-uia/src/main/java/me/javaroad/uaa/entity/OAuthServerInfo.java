package me.javaroad.uaa.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Base64Utils;

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
    private String redirectUrl;

    public String buildAuthorizationUrl(String redirectUrl) {
        return userAuthorizationUri + "?client_id=" + clientId + "&response_type=code&state=" + redirectUrl;
    }

    public String buildAccessTokenUrl(String code) {
        return accessTokenUri + "?grant_type=authorization_code&client_id=" + clientId
            + "&code=" + code + "&redirect_url" + redirectUrl;
    }

    public String buildAccessTokenUrl(String username, String password) {
        return accessTokenUri + "?grant_type=password&username=" + username
            + "&password=" + password;
    }

    public String buildBasicAuthString() {
        return "Basic " + Base64Utils.encodeToString((clientId + ":" + clientSecret).getBytes());
    }
}
