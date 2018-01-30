package me.javaroad.mcloud.uia;

import me.javaroad.mcloud.uia.config.OAuth2Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author heyx
 */
@EnableEurekaClient
@SpringBootApplication
@EnableConfigurationProperties(OAuth2Property.class)
public class UiaServer {

    public static void main(String[] args) {
        SpringApplication.run(UiaServer.class, args);
    }
}
