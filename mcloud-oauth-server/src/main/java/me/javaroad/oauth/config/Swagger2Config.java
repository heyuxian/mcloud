package me.javaroad.oauth.config;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author heyx
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static final String VERSION = "1.0";

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .build()
            .directModelSubstitute(LocalDate.class, java.sql.Date.class)
            .directModelSubstitute(LocalDate.class, java.util.Date.class)
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Swagger API")
            .description("MCloud-http://javaroad.me")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version(VERSION)
            .build();
    }
}
