package me.javaroad.mcloud.web.bind.annotation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author heyx
 */
@Retention(value = RUNTIME)
@Target(value = { PARAMETER })
public @interface CurrentUser {

}
