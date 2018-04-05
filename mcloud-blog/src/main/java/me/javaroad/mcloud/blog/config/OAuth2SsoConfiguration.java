package me.javaroad.mcloud.blog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableOAuth2Sso
@Configuration
public class OAuth2SsoConfiguration extends WebSecurityConfigurerAdapter {

    private final RequestMatcher authorizationHeaderRequestMatcher;

    public OAuth2SsoConfiguration(
        @Qualifier("authorizationHeaderRequestMatcher") RequestMatcher authorizationHeaderRequestMatcher) {
        this.authorizationHeaderRequestMatcher = authorizationHeaderRequestMatcher;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .requestMatcher(new NegatedRequestMatcher(authorizationHeaderRequestMatcher))
            .httpBasic()
            .realmName("MCloud blog")
            .and()
            .authorizeRequests()
            .antMatchers("/services/**").authenticated()
            .antMatchers("/eureka/**").hasRole("ADMIN")
            .antMatchers("/api/profile-info").permitAll()
            .antMatchers("/api/**").authenticated()
            .antMatchers("/config/**").hasRole("ADMIN")
            .antMatchers("/management/health").permitAll()
            .antMatchers("/management/**").hasRole("ADMIN")
            .anyRequest().permitAll();
    }
}
