package me.javaroad.uaa.config;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author heyx
 */
@ConfigurationProperties(prefix = "oauth2")
public class OAuthProvider {
    @Getter
    @Setter
    private Map<String, OAuthServerInfo> provider;
}
