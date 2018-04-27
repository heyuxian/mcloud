package me.javaroad.mcloud.demo;

import me.javaroad.mcloud.demo.config.KeycloakConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author heyx
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(KeycloakConfig.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
