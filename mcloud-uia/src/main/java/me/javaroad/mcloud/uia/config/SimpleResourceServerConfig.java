package me.javaroad.mcloud.uia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author heyx
 */
@Configuration
@ConditionalOnClass({OAuth2AccessToken.class, WebMvcConfigurerAdapter.class})
@EnableResourceServer
public class SimpleResourceServerConfig extends ResourceServerConfigurerAdapter {

    private ResourceServerProperties resourceServerProperties;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(resourceServerProperties.getResourceId());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // todo add permission check to monitoring.
            .authorizeRequests().antMatchers("/**").permitAll()
            .anyRequest().authenticated();
    }


    @Primary
    @Bean
    public ResourceServerTokenServices resourceServerTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        return tokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }


    @Autowired
    public void setResourceServerProperties(ResourceServerProperties resourceServerProperties) {
        this.resourceServerProperties = resourceServerProperties;
    }

}
