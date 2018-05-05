package me.javaroad.mcloud.apigw;

import me.javaroad.mcloud.apigw.config.GatewaySwaggerResourcesProvider.KeycloakProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author heyx
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
@EnableConfigurationProperties(KeycloakProperties.class)
public class ApiGatewayServer {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServer.class, args);
    }
}
