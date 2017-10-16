package me.javaroad.oauth.config;

import me.javaroad.data.config.JpaAuditingConfig;
import me.javaroad.web.config.Swagger2Config;
import me.javaroad.web.exception.DefaultExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    Swagger2Config.class,
    JpaAuditingConfig.class,
    DefaultExceptionHandler.class
})
@Configuration
public class AppConfig {

}
