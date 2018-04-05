package me.javaroad.mcloud.blog.config;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class OAuth2SecurityConfiguration extends ResourceServerConfigurerAdapter {

    private static final String OAUTH2_PRINCIPAL_ATTRIBUTE = "preferred_username";

    private static final String OAUTH2_AUTHORITIES_ATTRIBUTE = "roles";

    private ResourceServerProperties resourceServerProperties;

    public OAuth2SecurityConfiguration(ResourceServerProperties resourceServerProperties) {
        this.resourceServerProperties = resourceServerProperties;
    }

    @Bean
    @Primary
    public UserInfoTokenServices userInfoTokenServices(PrincipalExtractor principalExtractor,
        AuthoritiesExtractor authoritiesExtractor) {
        UserInfoTokenServices userInfoTokenServices = new UserInfoTokenServices(
            resourceServerProperties.getUserInfoUri(), resourceServerProperties.getClientId());
        userInfoTokenServices.setPrincipalExtractor(principalExtractor);
        userInfoTokenServices.setAuthoritiesExtractor(authoritiesExtractor);
        return userInfoTokenServices;
    }

    @Bean
    public PrincipalExtractor principalExtractor() {
        return map -> map.getOrDefault(OAUTH2_PRINCIPAL_ATTRIBUTE, "unknown")
            ;
    }

    @Bean
    public AuthoritiesExtractor authoritiesExtractor() {
        //noinspection unchecked
        return map ->
            Optional.ofNullable((List<String>) map.get(OAUTH2_AUTHORITIES_ATTRIBUTE))
                .filter(it -> !it.isEmpty())
                .orElse(Collections.singletonList("ROLE_USER"))
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(toList())
            ;
    }

    @Bean
    @Qualifier("authorizationHeaderRequestMatcher")
    public RequestMatcher authorizationHeaderRequestMatcher() {
        return new RequestHeaderRequestMatcher("Authorization");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .headers()
            .frameOptions()
            .disable()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .requestMatcher(authorizationHeaderRequestMatcher())
            .authorizeRequests()
            .antMatchers("/services/**").authenticated()
            .antMatchers("/api/profile-info").permitAll()
            .antMatchers("/api/**").authenticated()
            .antMatchers("/management/health").permitAll()
            .antMatchers("/management/**").hasRole("ADMIN");
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(getKeyFromAuthorizationServer());
        return converter;
    }

    private String getKeyFromAuthorizationServer() {
        return Optional.ofNullable(
            new RestTemplate()
                .exchange(
                    resourceServerProperties.getJwt().getKeyUri(),
                    HttpMethod.GET,
                    new HttpEntity<Void>(new HttpHeaders()),
                    Map.class
                )
                .getBody()
                .get("public_key"))
            .map(publicKey -> String.format("-----BEGIN PUBLIC KEY-----\n%s\n-----END PUBLIC KEY-----", publicKey))
            .orElse(resourceServerProperties.getJwt().getKeyValue());
    }
}
