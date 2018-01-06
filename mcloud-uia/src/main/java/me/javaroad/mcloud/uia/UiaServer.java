package me.javaroad.mcloud.uia;

import me.javaroad.mcloud.uia.config.OAuthProvider;
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
public class UiaServer {

    public static void main(String[] args) {
        SpringApplication.run(UiaServer.class, args);
    }
}
