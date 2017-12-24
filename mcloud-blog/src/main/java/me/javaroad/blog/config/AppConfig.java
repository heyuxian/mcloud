package me.javaroad.blog.config;

import me.javaroad.data.config.JpaAuditingConfig;
import me.javaroad.web.config.SimpleResourceServerConfig;
import me.javaroad.web.config.SimpleSwaggerConfig;
import me.javaroad.web.config.SimpleWebConfig;
import me.javaroad.web.exception.SimpleExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    JpaAuditingConfig.class,
    SimpleExceptionHandler.class,
    SimpleWebConfig.class,
    SimpleResourceServerConfig.class,
    SimpleSwaggerConfig.class
})
@Configuration
public class AppConfig {

}
