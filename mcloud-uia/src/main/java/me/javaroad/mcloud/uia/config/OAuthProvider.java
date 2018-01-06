package me.javaroad.mcloud.uia.config;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.mcloud.uia.entity.OAuthServerInfo;
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
