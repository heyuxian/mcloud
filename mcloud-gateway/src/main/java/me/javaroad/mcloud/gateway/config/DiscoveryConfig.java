package me.javaroad.mcloud.gateway.config;

import org.springframework.context.annotation.Configuration;

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

   /* @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
        DiscoveryClient discoveryClient) {

        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }*/
}
