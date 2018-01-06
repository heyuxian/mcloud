package me.javaroad.mcloud.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author heyx
 */
@EnableEurekaClient
@SpringBootApplication
public class BlogServer {

    public static void main(String[] args) {
        SpringApplication.run(BlogServer.class, args);
    }

}
