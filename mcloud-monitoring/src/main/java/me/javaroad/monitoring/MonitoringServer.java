package me.javaroad.monitoring;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author heyx
 */
@EnableEurekaClient
@EnableAdminServer
@SpringBootApplication
public class MonitoringServer {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringServer.class, args);
    }
}
