package org.blackc.blog.core.config;

import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author heyx
 */
@Configuration
@EnableOAuth2Client
public class OAuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("oauth2ClientContext")
    private OAuth2ClientContext oauth2ClientContext;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login/**", "/webjars/**").permitAll()
            .anyRequest()
            .authenticated().and()
            .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
            .logout().deleteCookies("remove").invalidateHttpSession(false);
        // @formatter:on
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    private Filter ssoFilter() {
        OAuth2ClientAuthenticationProcessingFilter oauthFilter = new OAuth2ClientAuthenticationProcessingFilter(
            "/login/mcloud");
        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(mcloud(), oauth2ClientContext);
        oauthFilter.setRestTemplate(facebookTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(mcloudResource().getUserInfoUri(),
            mcloud().getClientId());
        tokenServices.setRestTemplate(facebookTemplate);
        oauthFilter.setTokenServices(tokenServices);
        return oauthFilter;
    }

    @Bean
    @ConfigurationProperties(prefix = "mcloud.resource")
    public ResourceServerProperties mcloudResource() {
        return new ResourceServerProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "mcloud.client")
    public AuthorizationCodeResourceDetails mcloud() {
        return new AuthorizationCodeResourceDetails();
    }
}
