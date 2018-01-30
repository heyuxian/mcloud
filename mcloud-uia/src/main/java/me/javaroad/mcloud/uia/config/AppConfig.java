package me.javaroad.mcloud.uia.config;

import me.javaroad.mcloud.web.config.SimpleSwaggerConfig;
import me.javaroad.mcloud.web.exception.SimpleExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    SimpleExceptionHandler.class,
    SimpleSwaggerConfig.class
})
@Configuration
public class AppConfig {

}
