package me.javaroad.mcloud.demo.config;

import me.javaroad.mcloud.web.config.SimpleSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author heyx
 */
@Configuration
@Import(SimpleSwaggerConfig.class)
public class AppConfig {

}
