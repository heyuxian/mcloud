package me.javaroad.uaa;

import me.javaroad.uaa.config.OAuthProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author heyx
 */
@EnableEurekaClient
@SpringBootApplication
@EnableConfigurationProperties(OAuthProvider.class)
public class UIAServer {

    public static void main(String[] args) {
        SpringApplication.run(UIAServer.class, args);
    }
}
