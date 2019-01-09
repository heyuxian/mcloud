package me.javaroad.mcloud.common.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.swagger")
public class SwaggerProperties {

    private Boolean enabled;
    private ApiInfo apiInfo;
    private String basePackage;

    @Getter
    @Setter
    public static class ApiInfo {

        private String title = "";
        private String description = "";
        private String license = "";
        private String licenseUrl = "";
        private String termsOfServiceUrl = "";
        private String version = "1.0";
    }

    //todo security and others
}
