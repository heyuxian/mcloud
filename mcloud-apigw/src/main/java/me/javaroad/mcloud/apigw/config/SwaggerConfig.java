package me.javaroad.mcloud.apigw.config;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author heyx
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String VERSION = "1.0";

    @Value("${swagger.title:API Gateway}")
    private String title;
    @Value("${swagger.description:}")
    private String description;

    private final KeycloakProperties keycloakProperties;

    public SwaggerConfig(KeycloakProperties keycloakProperties) {
        this.keycloakProperties = keycloakProperties;
    }

    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("me.javaroad.mcloud.apigw"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .securitySchemes(Collections.singletonList(oauth()))
            ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version(VERSION)
            .build();
    }

    @Bean
    List<GrantType> grantTypes() {
        List<GrantType> grantTypes = new ArrayList<>();
        TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(
            keycloakProperties.getClient().getUserAuthorizationUri(),
            keycloakProperties.getClient().getClientId(), keycloakProperties.getClient().getClientSecret());
        TokenEndpoint tokenEndpoint = new TokenEndpoint(keycloakProperties.getClient().getAccessTokenUri(), "access_token");
        grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
        return grantTypes;
    }

    @Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
            .name("OAuth2")
            .scopes(scopes())
            .grantTypes(grantTypes())
            .build();
    }

    private List<AuthorizationScope> scopes() {
        return Lists.newArrayList(new AuthorizationScope("openid", "Grants openid access"));
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(keycloakProperties.getClient().getClientId(),
            keycloakProperties.getClient().getClientSecret(),
            "realm", keycloakProperties.getClient().getClientId(),
            "apiKey", ApiKeyVehicle.HEADER, "api_key", "");
    }
}
