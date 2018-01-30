package me.javaroad.mcloud.uia.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Base64Utils;

/**
 * @author heyx
 */
@Getter
@Setter
@ConfigurationProperties("mcloud.oauth2")
public class OAuth2Property {

    private Client client;
    private Server server;

    public String buildAuthUrl(String state) {
        return this.server.userAuthorizationUri
            + "?client_id=" + client.clientId
            + "&client_secret=" + client.clientSecret
            + "&response_type=code"
            + "&redirect_uri=" + client.callbackUri
            + "&state=" + state;
    }

    public String buildAccessTokenUrl(String username, String password) {
        return server.accessTokenUri + "?grant_type=password&username=" + username
            + "&password=" + password;
    }

    public String buildBasicAuthString() {
        return "Basic " + Base64Utils.encodeToString((client.clientId + ":" + client.clientSecret).getBytes());
    }

    @Getter
    @Setter
    public static class Client {

        private String clientId;
        private String clientSecret;
        private String callbackUri;
    }

    @Getter
    @Setter
    public static class Server {

        private String accessTokenUri;
        private String userAuthorizationUri;
    }
}
