package me.javaroad.uaa.config;

import me.javaroad.web.config.SimpleSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Import({
    SimpleSwaggerConfig.class
})
@Configuration
public class AppConfig {

}
