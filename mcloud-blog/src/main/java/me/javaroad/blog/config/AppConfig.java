package me.javaroad.blog.config;

import me.javaroad.data.config.JpaAuditingConfig;
import me.javaroad.web.config.DefaultResourceServerConfig;
import me.javaroad.web.config.DefaultSwaggerConfig;
import me.javaroad.web.config.DefaultWebConfig;
import me.javaroad.web.exception.DefaultExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    JpaAuditingConfig.class,
    DefaultExceptionHandler.class,
    DefaultWebConfig.class,
    DefaultResourceServerConfig.class,
    DefaultSwaggerConfig.class
})
@Configuration
public class AppConfig {

}
