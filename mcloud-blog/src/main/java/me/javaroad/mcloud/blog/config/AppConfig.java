package me.javaroad.mcloud.blog.config;

import me.javaroad.data.config.JpaAuditingConfig;
import me.javaroad.mcloud.web.config.SimpleSwaggerConfig;
import me.javaroad.mcloud.web.config.SimpleWebConfig;
import me.javaroad.mcloud.web.exception.ExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    JpaAuditingConfig.class,
    ExceptionTranslator.class,
    SimpleWebConfig.class,
    SimpleSwaggerConfig.class
})
@Configuration
public class AppConfig {

}
