package me.javaroad.uaa.config;

import me.javaroad.web.config.SimpleSwaggerConfig;
import me.javaroad.web.config.SimpleWebConfig;
import me.javaroad.web.exception.SimpleExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    SimpleWebConfig.class,
    SimpleExceptionHandler.class,
    SimpleSwaggerConfig.class
})
@Configuration
public class AppConfig {

}
