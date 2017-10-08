package me.javaroad.uaa;

import me.javaroad.uaa.config.OAuthProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author heyx
 */
@SpringBootApplication
@EnableConfigurationProperties(OAuthProvider.class)
public class UIAApplication {

    public static void main(String[] args) {
        SpringApplication.run(UIAApplication.class, args);
    }
}
