package me.javaroad.mcloud.gateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heyx
 */
@Configuration
public class DiscoveryConfig {

    /*@Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("mcloud-registry", predicate -> predicate.path("/registry/**")
                .filters(filter -> filter.rewritePath("/registry", "/"))
                .uri("lb://mcloud-registry"))
            .build();
    }*/

    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
        DiscoveryClient discoveryClient) {

        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }
}
