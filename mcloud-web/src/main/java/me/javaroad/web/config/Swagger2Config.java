/*
 * Copyright (c) 2017 https://github.com/heyx-any
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.javaroad.web.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
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

    @Value("${info.app.name}")
    private String serviceName;
    @Value("${info.app.desc}")
    private String serviceDesc;
    @Value("${uaa.url:}")
    private String oAuthServerUri;
    @Value("${uaa.clientId:}")
    private String clientId;
    @Value("${uaa.clientSecret:}")
    private String clientSecret;

    @Bean
    public Docket apiDocket() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
        if(!StringUtils.isBlank(oAuthServerUri)) {
            docket.securitySchemes(Lists.newArrayList(securitySchema()));
        }
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(serviceName)
            .description(serviceDesc)
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version(VERSION)
            .build();
    }

    private OAuth securitySchema() {
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant =
            new ResourceOwnerPasswordCredentialsGrant("http://localhost:8043/uaa/oauth/token");
        List<GrantType> grantTypes = Collections.singletonList(resourceOwnerPasswordCredentialsGrant);
        return new OAuth("oauth2", scopes(), grantTypes);
    }

    private List<AuthorizationScope> scopes() {
        List<AuthorizationScope> list = Lists.newArrayList();
        list.add(new AuthorizationScope("read", "Grants read access"));
        return list;
    }
}
