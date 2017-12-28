package me.javaroad.blog;

import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author heyx
 */
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    FlywayTestExecutionListener.class
})
public abstract class BaseRepositoryTest extends BaseSpringTest {
}
