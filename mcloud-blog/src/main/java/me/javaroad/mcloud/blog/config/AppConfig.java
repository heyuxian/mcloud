package me.javaroad.mcloud.blog.config;

import me.javaroad.data.config.JpaAuditingConfig;
import me.javaroad.mcloud.web.config.SimpleResourceServerConfig;
import me.javaroad.mcloud.web.config.SimpleSwaggerConfig;
import me.javaroad.mcloud.web.config.SimpleWebConfig;
import me.javaroad.mcloud.web.exception.SimpleExceptionHandler;
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
